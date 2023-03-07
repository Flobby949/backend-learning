package top.flobby.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import top.flobby.spring.entity.User;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description : FirstController
 * @create : 2023-03-07 14:09
 **/

public class FirstController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 创建一个模型视图对象
        ModelAndView view = new ModelAndView();
        // 向模型中添加数据
        view.addObject("msg", "My First MVC Application!");
        view.addObject("user", new User("Flobby"));
        // 设置视图名称
        view.setViewName("/WEB-INF/jsp/first.jsp");
        return view;
    }
}
