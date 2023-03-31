package top.flobby.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Flobby
 * @program : spring-security-learning
 * @description : Hello
 * @create : 2023-03-31 12:28
 **/

@RestController
@RequestMapping("api")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello,security";
    }
}
