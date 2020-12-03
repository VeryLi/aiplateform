package com.ai.dispatcher.utils;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager cm;
    private static String UTF_8 = "UTF-8";

    private static void init() {
        if (cm == null) {
            synchronized (HttpClientUtil.class) {
                if (cm == null) {
                    cm = new PoolingHttpClientConnectionManager();
                    // 整个连接池最大连接数
                    cm.setMaxTotal(50);
                    // 每路由最大连接数，默认值是2
                    cm.setDefaultMaxPerRoute(5);
                }
            }
        }
    }

    /**
     * 通过连接池获取HttpClient
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        return HttpClients
                .custom()
                .setConnectionManager(cm)
                .build();
    }

    public static Response httpGetRequest(String url) {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    public static Response httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params) throws URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);
        HttpGet httpGet = new HttpGet(ub.build());
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        return getResult(httpGet);
    }

    public static Response httpPostRequest(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json, "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        return getResult(httpPost);
    }

    public static Response httpPostRequest(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }

    public static Response httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));

        return getResult(httpPost);
    }

    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }
        return pairs;
    }

    private static Response getResult(HttpRequestBase request) {
        Response response = Response.builder()
                .httpStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .content("")
                .errorMessage("")
                .build();
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(request);
            int httpStatusCode = httpResponse.getStatusLine().getStatusCode();
            response.setHttpStatus(httpStatusCode);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                response.setContent(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            response.setHttpStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            response.setContent("");
            response.setErrorMessage(e.getMessage());
        } finally {
            if(httpResponse != null){
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return response;
    }

    @Data
    @Builder
    public static class Response {
        private int httpStatus;
        private String content;
        private String errorMessage;
    }

}