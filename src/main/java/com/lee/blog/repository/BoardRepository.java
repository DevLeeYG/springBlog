package com.lee.blog.repository;

import com.lee.blog.model.Board;
import com.lee.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//데이터 베이스 에 인서트 하기위해 레파지토리를 만든다

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
