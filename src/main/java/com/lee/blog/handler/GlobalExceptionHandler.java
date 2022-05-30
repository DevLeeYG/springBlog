package com.lee.blog.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //어디에서든 이졲으로 익셉션이 발생하면 오도록
@RestController
public class GlobalExceptionHandler {


    @ExceptionHandler(value=IllegalArgumentException.class)
    public String handleArgumentException(Exception e){
        return "<h1>"+e.getMessage()+"</h1>";
    }


}
