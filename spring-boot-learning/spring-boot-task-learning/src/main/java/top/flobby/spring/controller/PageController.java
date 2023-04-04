package top.flobby.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-04 15:38
 **/

@Controller
public class PageController {
    @GetMapping("index")
    public String getIndex() {
        return "index";
    }

}
