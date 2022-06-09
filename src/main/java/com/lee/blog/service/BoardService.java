package com.lee.blog.service;



import com.lee.blog.model.Board;
import com.lee.blog.model.RoleType;
import com.lee.blog.model.User;
import com.lee.blog.repository.BoardRepository;
import com.lee.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;



    @Transactional
    public void 글쓰기(Board board,User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public List<Board> 글목록(){
        return boardRepository.findAll();
    }

}
