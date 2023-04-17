package top.flobby.push;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 服务器推送
 * @create : 2023-04-17 13:36
 **/

@EnableScheduling
@SpringBootApplication
public class SpringBootServerPushApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServerPushApplication.class, args);
    }
}
