package top.flobby.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志演示应用程序
 *
 * @author Flobby
 * @date 2023/04/03
 */

@Slf4j
@SpringBootApplication
public class LogDemoApplication {

    public static void main(String[] args) {
        log.info("启动");
        SpringApplication.run(LogDemoApplication.class, args);
    }

}
