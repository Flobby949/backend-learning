package top.flobby.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-16 19:53
 **/

@EnableCaching
@SpringBootApplication
@MapperScan("top.flobby.cache.mapper")
public class SpringBootCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }
}
