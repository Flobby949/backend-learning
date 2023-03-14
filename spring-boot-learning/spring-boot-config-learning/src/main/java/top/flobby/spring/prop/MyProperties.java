package top.flobby.spring.prop;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-14 15:00
 **/

@Configuration  // 标注配置类
@PropertySource("classpath:my.properties")  // 指定目录和文件名
@ConfigurationProperties(prefix = "my") // 指定注入属性前缀
@Setter
@ToString
public class MyProperties {
    private String url;
    private String username;
    private String password;
}
