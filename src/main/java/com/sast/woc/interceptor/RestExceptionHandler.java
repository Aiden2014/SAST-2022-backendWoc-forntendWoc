package com.sast.woc.interceptor;

import com.sast.woc.entity.ResultData;
import com.sast.woc.entity.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        if(e.getMessage()=="token不能为空"||e.getMessage()=="token不合法"){
            return ResultData.fail(ReturnCode.RC401.getCode(),e.getMessage());
        }
        if(e.getMessage()=="操作失败"){
            return ResultData.fail(ReturnCode.RC404.getCode(),e.getMessage());
        }
        if(e.getMessage()=="用户名或密码错误"){
            return ResultData.fail(ReturnCode.RC401.getCode(),e.getMessage());
        }
        if(e.getMessage()=="无权限"){
            return ResultData.fail(ReturnCode.RC403.getCode(),e.getMessage());
        }
        return ResultData.fail(ReturnCode.RC500.getCode(),e.getMessage());
    }
}