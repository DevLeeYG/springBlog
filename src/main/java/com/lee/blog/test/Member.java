package com.lee.blog.test;

//모델
public class Member {
    private  int id;
    private String username;
    private String password;
    private String email;

    public Member(int id,String username,String password,String email){

        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getUsername(){
        return username
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public  String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
//자바에서 변수는 보통 private 로 만든다
//변수의 상태는 메서드를 이용해서 변경되게 한다