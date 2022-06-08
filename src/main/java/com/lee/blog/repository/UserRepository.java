package com.lee.blog.repository;

import com.lee.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
//데이터 베이스 에 인서트 하기위해 레파지토리를 만든다

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
//jpa naming 쿼리
//SELECT * FROM user WHERE username = ? AND password = ?
//findByUsernameAndPassword 이 이름으로 했을경우 저런 쿼리가 동장된다
//    User findByUsernameAndPassword(String username,String password);

//    @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2",nativeQuery = true)
//    User login(String username, String password);
//해당 레파지토리는 유저를 관리하며 프라이머리 키는 인티져이다