package top.flobby.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * spring引导任务应用程序
 *
 * @author Flobby
 * @date 2023/04/04
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringBootTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskApplication.class, args);
    }
}