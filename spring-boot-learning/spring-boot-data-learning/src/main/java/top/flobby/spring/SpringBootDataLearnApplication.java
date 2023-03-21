package top.flobby.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Flobby
 * @date 2023/03/20
 */

@SpringBootApplication
@MapperScan("top.flobby.spring.mapper")
public class SpringBootDataLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataLearnApplication.class, args);
    }
}