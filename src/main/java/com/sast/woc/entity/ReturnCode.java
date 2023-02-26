package com.sast.woc.entity;

public enum ReturnCode {
    /**操作成功**/
    RC200(200,"操作成功"),
    /**登录失败或者无token或者token不合法**/
    RC401(401," Unauthorized"),
    /**无权限**/
    RC403(403,"没有权限访问该资源"),
    /**操作失败**/
    RC404(404,"操作失败"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试");
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}