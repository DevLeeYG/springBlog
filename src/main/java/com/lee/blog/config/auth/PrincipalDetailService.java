package com.lee.blog.config.auth;

import com.lee.blog.model.User;
import com.lee.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //bean 등록
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //스프링이 로그인 요철을 가로챌떄, username,password 변수 2개를 가로채는데
    //password 부분 처리는 알아서 함.
    //username이 DB에 있는지만 확인해면 됨
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자를 찾을수 없습니다.");
                });
        return new PrincipalDetail(principal);
    }
}
