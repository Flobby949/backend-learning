package top.flobby.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.spring.config.DBConfig;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-14 15:57
 **/

@RestController
@AllArgsConstructor
public class DBController {
    private final DBConfig dbConfig;

    @GetMapping("show")
    public String getProfile() {
        return dbConfig.sysProfile();
    }
}
