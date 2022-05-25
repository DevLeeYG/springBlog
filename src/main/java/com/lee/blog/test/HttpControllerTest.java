package com.lee.blog.test;


import org.springframework.web.bind.annotation.*;

//응답이 HTML 파일이면 @Controller
//응답이 data 이면 RestController

@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(Member m){
        return "get요청:" + m.getId()+"."+m.getUsername()+"."+m.getPassword()+"."+m.getEmail();
    }
    @PostMapping("/http/post")//바디로 들어온 데이터를 맵핵해서 보내준다
    public String postTest(@RequestBody Member m){
        return "post:" + m.getId()+"."+m.getUsername()+"."+m.getPassword()+"."+m.getEmail();
    }
    @PutMapping("/http/put")

    public String putTest(@RequestBody Member m){
        return "put:" + m.getId()+"."+m.getUsername()+"."+m.getPassword()+"."+m.getEmail();
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(@RequestBody Member m){
        return "delete:" + m.getId()+"."+m.getUsername()+"."+m.getPassword()+"."+m.getEmail();
    }


}
