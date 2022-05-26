package com.lee.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;


import javax.persistence.*;
import java.sql.Timestamp;
//이 오브젝트를 테이블화 시켜줌
 // 테이블화 시키기위한 어노테이션


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
//@DynamicInsert insert 시에 널인필드를 제외
@Entity
public class User {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 db의 넘버링 전략을 따라간다.
    private int id; //auo-increment
    @Column(nullable = false,length = 30)
    private String username;
    @Column(nullable = false,length = 100)//암호화되면 길어질수있어서 100으로 잡음
    private String password;
    @Column(nullable = false,length = 30)
    private String email;

    private String role;// Enum 을 쓰는게 좋다
    @CreationTimestamp //시간이 자동입력
    private Timestamp createDate;
}
