package com.lihuanyu.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String no;
    @NotNull
    private String nickname;
    private String avatar;
    private String name;
    @NotNull
    private String password;
    private int role_type;
    @NotNull
    private int status;
    private String mail;
    private String major;
    private String academy;

    public User(){    }

    public User(long id){
        this.id = id;
    }

    public User(String nickname,String password){
        this.nickname = nickname;
        this.password = password;
        this.status = 1;
        this.mail = "123@qq.com";
    }

    public User(String no,String mail,String nickname,String avatar,String name,String password,int role_type,int status,String major,String academy){
        this.no = no;
        this.mail = mail;
        this.nickname = nickname;
        this.avatar = avatar;
        this.name = name;
        this.password = password;
        this.role_type = role_type;
        this.status = status;
        this.major = major;
        this.academy = academy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_type() {
        return role_type;
    }

    public void setRole_type(int role_type) {
        this.role_type = role_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
