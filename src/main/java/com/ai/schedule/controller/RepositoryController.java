package com.ai.schedule.controller;

import com.ai.schedule.bean.CommonResponse;
import com.ai.schedule.bean.repo.CreatingStaticRepositoryRequest;
import com.ai.schedule.bean.repo.CreatingStaticRepositoryResponse;
import com.ai.schedule.bean.repo.DeletingStaticRepositoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 该类主要负责库管理的有关请求
 */
@Slf4j
@RestController
@RequestMapping("/static_repository")
public class RepositoryController {

    /**
     * 创建静态库
     *
     * @param creatingStaticRepositoryRequest 创建静态库请求
     * @param httpServletRequest httpServlet请求
     * @return 返回结果响应
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public CreatingStaticRepositoryResponse createStaticRepository(@Validated @RequestBody CreatingStaticRepositoryRequest creatingStaticRepositoryRequest,
                                                                   HttpServletRequest httpServletRequest){
        return null;
    }

    /**
     * 删除静态库
     *
     * @param deletingStaticRepositoryRequest 删除静态库请求
     * @param httpServletRequest httpServlet请求
     * @return 返回结果响应
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE)
    public CommonResponse deleteStaticRepository(@Validated @RequestBody DeletingStaticRepositoryRequest deletingStaticRepositoryRequest,
                                                 HttpServletRequest httpServletRequest){
        return null;
    }

}
