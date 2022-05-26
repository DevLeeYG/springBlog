package com.lee.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false , length = 100)
    private String title;

    @Lob
    private  String content;

    @ColumnDefault("0")//조회수
    private  int count;


    @ManyToOne(fetch = FetchType.EAGER) //Many = board, User = One // 하나의 유저는 많은 게시물을 쓸수있다.
    @JoinColumn(name="userId")//데이터베이스에느 userID 로 만들어진다.
    private  User user; //db는 오브젝트를 저장할수 없어서. FK를 사용하는데 자바는 오브젝트를 저장할수 있다. o

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER)//mappedBy 연관관계의 주인이 아니다 not Fk db에 컬럼을 만들지 마세요.
    private List<Reply> reply;
    @CreationTimestamp
    private Timestamp createDate;


}
