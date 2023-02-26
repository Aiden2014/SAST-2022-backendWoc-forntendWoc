package com.sast.woc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author xun&&Aiden2014
 * @create 2023/2/14 17:00
 */
@CrossOrigin
@RestController
@RequestMapping("/error")
public class ErrorController {
    /**
     * token验证抛出异常给过滤器接收到
     * @param request 用户名
     * @return User
     */
    @RequestMapping("/errorToken")
    public void errorToken(HttpServletRequest request){
        System.out.println(request);
        throw ((RuntimeException) request.getAttribute("filter.error"));
    }
}
