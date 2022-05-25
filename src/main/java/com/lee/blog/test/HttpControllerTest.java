package com.lee.blog.test;


import org.springframework.web.bind.annotation.*;

//응답이 HTML 파일이면 @Controller
//응답이 data 이면 RestController

@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(){
        return "get요청";
    }
    @PostMapping("/http/post")
    public String posTest(){
        return "post요청";
    }
    @PutMapping("/http/put")

    public String putTest(){
        return "put요청";
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete요청";
    }


}
