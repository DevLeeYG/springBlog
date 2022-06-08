package com.lee.blog.controller;

import com.lee.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Controller 주로 View 반환하기 위해 사용
public class BoardController {


    @GetMapping({"","/"})
    public String index(@AuthenticationPrincipal PrincipalDetail principal){
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveFrom(){
        return "board/saveForm";
    }
}
