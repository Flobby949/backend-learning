package top.flobby.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-18 15:54
 **/

@EnableAdminServer
@SpringBootApplication
public class SpringBootAdminServer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServer.class, args);
    }
}
