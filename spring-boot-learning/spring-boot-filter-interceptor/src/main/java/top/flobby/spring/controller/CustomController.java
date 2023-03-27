package top.flobby.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 接口
 * @create : 2023-03-27 14:44
 **/

@Slf4j
@Controller
@RequestMapping("api")
public class CustomController {

    @GetMapping("test")
    public void testListener() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute("author", "flobby");
        request.setAttribute("author", "jjjcx");
        request.removeAttribute("author");
        log.info("controller 执行");
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
