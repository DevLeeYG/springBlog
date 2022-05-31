package com.lee.blog.service;


import com.lee.blog.model.User;
import com.lee.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Integer 회원가입(User user) {

        try {
             userRepository.save(user);
             return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(("UserService:회원가입"+e.getMessage()));
        }
        return -1;
    }
}
