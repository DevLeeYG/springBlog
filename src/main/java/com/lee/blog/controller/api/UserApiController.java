package com.lee.blog.controller.api;

import com.lee.blog.dto.ResponseDto;
import com.lee.blog.model.RoleType;
import com.lee.blog.model.User;
import com.lee.blog.repository.UserRepository;
import com.lee.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController:save호출");
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK,1);
    }

}
