package com.song.common.util.exception;

import com.song.common.base.enums.HttpStatus;

/**
 * @author Song.X
 * Date: 2020/9/29
 * Description: 异常断言
 */
public abstract class ReturnAssert {

    /**
     * 空指针异常
     * @param t 可能为空对象
     * @param httpStatus 状态
     * @param <T> 泛型
     */
    public static <T> void notNull(T t, HttpStatus httpStatus){
        if (t == null){
            throw new DiyException(httpStatus);
        }
    }
    /**
     * 未登录
     * @param t 用户
     * @param <T> 泛型
     */
    public static <T> void noLogin(T t){
        if (t == null){
            throw new DiyException(HttpStatus.NO_LOGIN);
        }
    }


}
