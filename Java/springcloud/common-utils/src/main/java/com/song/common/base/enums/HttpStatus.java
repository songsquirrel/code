package com.song.common.base.enums;


/**
 * @author Song.X
 * Date: 2020/9/28
 * Description: http status code
 */
public enum HttpStatus {
    /**
     * 状态码说明:
     * 200-299: 请求正常
     * 300-399: 请求正常, 但需额外操作完成功能
     * 400-499: 调用方错误
     * 500-599: 系统内部错误
     */
    OK(200, "请求成功!"),
    NO_LOGIN(301, "未登录, 请先登录!"),
    AUTH_FAILED(302, "无权限, 禁止访问!"),
    OPERATION_FAILED(303, "操作失败!"),
    REQUEST_FAILED(401, "调用方请求失败!"),
    ERR_ARGS(405, "参数错误, 请核对!"),
    ERR_FORMAT_DATE(406, "日期格式化异常!"),
    ERR_SYSTEM(501, "系统错误, 请联系管理员!");


    HttpStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private final int status;
    private final String message;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
