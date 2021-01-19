package com.song.common.base.entity;

import com.song.common.base.enums.HttpStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Song.X
 * Date: 2020/9/28
 * Description: interface return value entity
 */

@Data
public class ReturnValue<T> implements Serializable {
    private static final long serialVersionUID = 6707057192077978944L;
    /**
     * 状态码, 默认200
     */
    private int status;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;



    /**
     * 请求成功
     * @param data 返回数据
     * @param <T> 泛型
     * @return 返回值
     */
    public static <T> ReturnValue<T> success(T data){
        return successOrFailed(HttpStatus.OK.getStatus(), HttpStatus.OK.getMessage(),  data);
    }

    /**
     * 请求失败
     * @param <T> 泛型
     * @param httpStatus 失败状态
     * @return 返回值
     */
    public static <T> ReturnValue<T> failed(HttpStatus httpStatus){
        return failed(httpStatus.getStatus(), httpStatus.getMessage(), null);
    }

    /**
     * 请求失败
     * @param <T> 泛型
     * @param httpStatus 失败状态
     * @return 返回值
     */
    public static <T> ReturnValue<T> failed(HttpStatus httpStatus, T data){
        return failed(httpStatus.getStatus(), httpStatus.getMessage(), data);
    }

    /**
     * 构造返回值
     * @param <T> 泛型
     * @param status 状态码
     * @param message 返回信息
     * @return 返回值
     */
    public static <T> ReturnValue<T> failed(int status, String message, T data){
        ReturnValue<T> returnValue = new ReturnValue<>();
        returnValue.setStatus(status);
        returnValue.setMessage(message);
        returnValue.setData(data);
        return returnValue;
    }
    /**
     * 构造返回值
     * @param <T> 泛型
     * @param status 状态码
     * @param message 返回信息
     * @param data 返回数据
     * @return 返回值
     */
    private static <T> ReturnValue<T> successOrFailed(int status, String message, T data){
        ReturnValue<T> returnValue = new ReturnValue<>();
        returnValue.setStatus(status);
        returnValue.setMessage(message);
        returnValue.setData(data);
        return returnValue;
    }

    /**
     * 构造返回值
     * @param condition 条件, 为真为请求成功
     * @param data 返回数据
     * @param <T> 返回数据类型
     * @return 返回值
     */
    public static <T> ReturnValue<T> successOrFailed(boolean condition, T data){
        if (condition){
            return success(data);
        }else{
            return failed(HttpStatus.OPERATION_FAILED);
        }
    }
}
