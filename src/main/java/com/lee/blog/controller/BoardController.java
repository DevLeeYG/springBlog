package com.lee.blog.controller;

import com.lee.blog.config.auth.PrincipalDetail;
import com.lee.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Controller 주로 View 반환하기 위해 사용
public class BoardController {


    @Autowired
    private BoardService boardService;

    @GetMapping({"","/"})
//    @AuthenticationPrincipal PrincipalDetail principal
    public String index(Model model){
        model.addAttribute("boards",boardService.글목록());//model은 리퀘스트 정보
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveFrom(){
        return "board/saveForm";
    }
}
