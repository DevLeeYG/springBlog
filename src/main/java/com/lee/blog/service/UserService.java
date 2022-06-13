package com.lee.blog.service;


import com.lee.blog.model.RoleType;
import com.lee.blog.model.User;
import com.lee.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Persistence;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;



    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    @Transactional
    public void 회원수정(User user){
        User persistence = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원찾기 실패");
        });

        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        persistence.setPassword(encPassword);
        persistence.setEmail(user.getEmail());

    }
}
