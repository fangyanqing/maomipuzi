package com.maomipuzi.framework.exception;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/*****
 * @Author: www.itheima.com
 * @Description: com.maomipuzi.framework.exception
 * 全局异常处理
 ****/
@ControllerAdvice
public class BaseExceptionHandler {

    /***
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception  e){
        return new Result(false,StatusCode.REMOTEERROR,e.getMessage());
    }
}
