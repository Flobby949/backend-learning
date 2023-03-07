package top.flobby.spring.vo;

import top.flobby.spring.entity.User;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description :
 * @create : 2023-03-07 22:54
 **/

public class UserVO {
    private List<User> userList;

    public UserVO(List<User> userList) {
        this.userList = userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }
}
