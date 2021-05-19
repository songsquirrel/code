package com.walker.common.util.exception;

import com.walker.common.base.entity.ReturnValue;
import com.walker.common.base.enums.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author Song.X
 * Date: 2020/9/28
 * Description: exception deal
 * PS: 其他模块引用如包名不同, 需要在要引用的模块的@SpringBootApplication注解的ScanPackages加上此包的扫描
 */
@RestControllerAdvice
@Slf4j
public class RestAdviceExceptionHandler {

    /**
     * 异常统一处理
     *
     * @param e 异常
     * @return 返回失败
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnValue exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ReturnValue.failed(HttpStatus.ERR_SYSTEM, e.getMessage());
    }

    /**
     * 参数校验统一异常处理
     *
     * @param argsException 参数异常
     * @return 参数错误信息
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ReturnValue argsError(MethodArgumentNotValidException argsException) {
        BindingResult bindingResult = argsException.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError err : allErrors) {
            return ReturnValue.failed(HttpStatus.ERR_ARGS, err.getDefaultMessage());
        }
        return ReturnValue.failed(HttpStatus.ERR_ARGS);
    }

    /**
     * 自定义异常处理
     *
     * @param e 自定义异常
     * @return 错误信息
     */
    @ExceptionHandler(value = DiyException.class)
    @ResponseBody
    public ReturnValue diyExceptionHandler(DiyException e) {
        return ReturnValue.failed(e.getHttpStatus());
    }

    /**
     * JackSon格式化错误
     *
     * @param e JackSon格式化异常
     * @return 错误信息
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ReturnValue invalidFormatExceptionHandler(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return ReturnValue.failed(HttpStatus.ERR_ARGS, e.getMessage());
    }
}
