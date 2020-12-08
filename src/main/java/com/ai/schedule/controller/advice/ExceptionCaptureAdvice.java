package com.ai.schedule.controller.advice;

import com.ai.schedule.bean.CommonResponse;
import com.ai.schedule.commons.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionCaptureAdvice {

    /**
     * 捕捉其他所有异常
     *
     * @param e 异常
     * @return 返回通用response对象
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse othersException(Exception e) {
        log.error(e.getMessage(), e);
        CommonResponse response = new CommonResponse();
        response.setStatusCode(Constants.Failed);
        response.setStatusMessage("Inner Error. Please contact with Administrator.");
        return response;
    }

    /**
     * 捕捉所有数据字段校验异常
     *
     * @param e 数据校验失败异常
     * @return 返回通用response对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse validationException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        StringBuilder stringBuilder = new StringBuilder();
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        for (FieldError error : errors) {
            stringBuilder.append(error.getDefaultMessage()).append(";");
        }
        CommonResponse response = new CommonResponse();
        response.setStatusCode(Constants.Failed);
        if (StringUtils.isBlank(stringBuilder.toString())) {
            stringBuilder.append(e.getMessage());
        }
        response.setStatusMessage(stringBuilder.toString());
        return response;
    }
}
