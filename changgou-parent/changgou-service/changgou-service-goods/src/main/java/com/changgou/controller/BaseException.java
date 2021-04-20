package com.changgou.controller;/**
 * @Author panqian
 * @Date 2020/9/24 11:07
 * @Version 1.0.0
 */

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author panqian
 * @Date 2020/9/24 11:07
 * @Version 1.0.0
 */
@ControllerAdvice
public class BaseException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
