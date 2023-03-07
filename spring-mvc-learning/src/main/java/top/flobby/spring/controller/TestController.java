package top.flobby.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description : 注解方式
 * @create : 2023-03-07 14:49
 **/

@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "Hello";
    }
}
