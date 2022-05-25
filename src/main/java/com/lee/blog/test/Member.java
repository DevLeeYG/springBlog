package com.lee.blog.test;

import lombok.*;

//모델
//@Getter
//@Setter
//@Data//Getter 와 Setter 합친것
////@AllArgsConstructor 생성자
//
////final은 불변성을 위해 데이터 베이스에 가지고온 값을 변경하지 않는다면..
////변경할려면 파이널을 붙이면 안된다
//@RequiredArgsConstructor //파이널이 붙은것에대한 콘스트럭터
@Data

@NoArgsConstructor//빈생성자

public class Member {
    private int id;
    private String username;
    private String password;
    private String email;
@Builder
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


}
//자바에서 변수는 보통 private 로 만든다
//변수의 상태는 메서드를 이용해서 변경되게 한다