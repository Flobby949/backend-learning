package top.flobby.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.flobby.spring.entity.User;
import top.flobby.spring.vo.UserVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description :
 * @create : 2023-03-07 20:09
 **/

@Controller
public class UserController {
    @RequestMapping("selectUser")
    public String selectUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println("id=" + id);
        return "success";
    }

    @RequestMapping("toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/registerUser")
    public String register(User user) {
        String name = user.getName();
        String password = user.getPassword();
        System.out.println(name);
        System.out.println(password);
        return "success";
    }

    @RequestMapping("toUser")
    public String selectUsers() {
        return "user";
    }

    @RequestMapping("deleteUsers")
    public String deleteUsers(Integer[] ids) {
        if (ids != null) {
            for (Integer id : ids) {
                System.out.println("删除id为" + id + "的用户！");
            }
        } else {
            System.out.println("ids=null");
        }
        return "success";
    }

    @RequestMapping("toUserEdit")
    public String toUserEdit() {
        return "user_edit";
    }

    @RequestMapping("editUser")
    public String editUsers(UserVO userList) {
        // 将所有的用户数据封装到集合中
        List<User> users = userList.getUserList();
        // 遍历用户信息
        users.forEach(item -> {
            if (item.getId() != null) {
                System.out.println("修改了id" + item.getId() + "的用户名为：" + item.getName());
            }
        });
        return "success";
    }
}
