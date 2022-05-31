package com.lee.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Controller 주로 View 반환하기 위해 사용
public class BoardController {


    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

}
