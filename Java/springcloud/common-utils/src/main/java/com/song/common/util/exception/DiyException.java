package com.song.common.util.exception;


import com.song.common.base.enums.HttpStatus;

import java.io.Serializable;

/**
 * @author Song.X
 * Date: 2020/9/28
 * Description:
 */
public class DiyException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 状态
     */
    private HttpStatus httpStatus;

    public DiyException(HttpStatus httpStatus) {
        super(httpStatus.getMessage());
        this.httpStatus = httpStatus;
    }


    /**
     * 获取返回状态码
     *
     * @return
     */
    public int getStatus() {
        return this.httpStatus.getStatus();
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }


    @Override
    public String getMessage() {
        return this.httpStatus.getMessage();
    }
}
