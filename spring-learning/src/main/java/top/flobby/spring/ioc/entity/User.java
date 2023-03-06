package top.flobby.spring.ioc.entity;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:49
 **/
public class User {
    private String username;
    private String password;
    private List<String> list;

    public User(String username, String password, List<String> list) {
        this.username = username;
        this.password = password;
        this.list = list;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", list=" + list +
                '}';
    }
}
