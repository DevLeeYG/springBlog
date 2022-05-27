package com.lee.blog.repository;

import com.lee.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//데이터 베이스 에 인서트 하기위해 레파지토리를 만든다

public interface UserRepository extends JpaRepository<User,Integer> {
}
//해당 레파지토리는 유저를 관리하며 프라이머리 키는 인티져이다