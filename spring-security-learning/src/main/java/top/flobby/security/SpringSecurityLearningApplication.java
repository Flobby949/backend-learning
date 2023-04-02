package top.flobby.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Flobby
 */
@SpringBootApplication
@MapperScan("top.flobby.security.auth.mapper")
public class SpringSecurityLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearningApplication.class, args);
    }

}
