package com.lee.blog.test;


import com.lee.blog.model.RoleType;
import com.lee.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import com.lee.blog.model.User;

import javax.transaction.Transactional;
import java.util.List;

import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired//의존성 주입
    private UserRepository userRepository;

    //주소로 파라미터를 받을수 있음
    //user 가 있으면 바로 user 를 리턴하지만 없다면 get 함수가 실행된다(빈객체 는 null은 아니다)

    @GetMapping("/dummy/users")
    public List<User> list(){//유저 리스트 를 받아야되서 리스트 를 쓴다다
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
      User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
          @Override
          public IllegalArgumentException get() {
              return new IllegalArgumentException("해당유저는 없습니다 id :"+id);
          }
      });
      //요청 :웹브라우저
    //변환(웹브라우저가 이해할 수 있는 데이터)-> json(Gson 라이브러리)
    //스프링부트 = MessageConverter 라는 애가 응답시에 자동 작동
    //만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
    //user 오브젝트를 json 으로
    //user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.(스프링에서 다 해주네)
    //user 객체 = 자바 오브젝트
       return user;

    }
    @GetMapping("/dummy/user")
   public List<User> pageList(@PageableDefault(size=2,sort="id",direction=Sort.Direction.DESC) Pageable pageable){
      Page<User> pagingUser = userRepository.findAll(pageable);

      List<User> users = pagingUser.getContent();
      return users;
    }




    @PostMapping("/dummy/join")
    public String join(User user){
//        System.out.println("username:" + user.getUsername());
//        System.out.println("username:" + user.getPassword());
//        System.out.println("username:" + user.getEmail());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
    //email,password
    //@RequestBody = json 데이터를 받을때
    //save 함수는 id를 전달하지 않으면 insert 를해주고
    //save 함수는 id 를 전달하면 해당 id 에 대한 데이터가 있으면 update를 해주고
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User requestUser){
        System.out.println("id:"+id);
        System.out.println("password: " + requestUser.getPassword());
        System.out.println("email "+requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패 하였습니다");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());


//        userRepository.save(user);

        return null;
    }


}
