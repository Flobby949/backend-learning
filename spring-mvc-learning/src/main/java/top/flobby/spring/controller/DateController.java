package top.flobby.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description : 测试时间类型转换器
 * @create : 2023-03-07 20:26
 **/

@Controller
public class DateController {
    @RequestMapping("customDate")
    public String customDate(Date date) {
        System.out.println("date=" + date);
        return "success";
    }
}
