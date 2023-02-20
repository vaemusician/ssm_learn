package com.atguigu.mybatis.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String gender;

    private String emil;

    public User() {
    }

    public User(Integer id, String username, String password, Integer age, String gender, String emil) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.emil = emil;
    }
}



