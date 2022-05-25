package com.lee.blog.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//파일을 리턴함 RestController 는 데이터를 리턴
public class TempControllerTest {

    @GetMapping("/temp/home")

    public String tempHome(){
         System.out.println("tempHome()");
         return "/home.html";
    }

}
