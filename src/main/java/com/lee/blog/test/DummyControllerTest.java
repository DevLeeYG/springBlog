package com.lee.blog.test;


import com.lee.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lee.blog.model.User;
@RestController
public class DummyControllerTest {

    @Autowired//의존성 주입
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user){
//        System.out.println("username:" + user.getUsername());
//        System.out.println("username:" + user.getPassword());
//        System.out.println("username:" + user.getEmail());
        user.setRole("user");
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

}
