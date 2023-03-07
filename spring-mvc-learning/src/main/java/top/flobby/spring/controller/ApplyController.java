package top.flobby.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description : 问卷调查
 * @create : 2023-03-07 17:06
 **/

@RestController
public class ApplyController {

    @PostMapping("apply")
    public String apply(@RequestParam(value = "username", defaultValue = "Flobby") String username,
                        @RequestParam String course,
                        @RequestParam List<Integer> purpose) {
        return "{\"用户名\": " + username + ",\"课程\": " + course + ", \"目的\": " + purpose + "}";
    }
}
