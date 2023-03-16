package top.flobby.spring.prop;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 阿里云配置
 * @create : 2023-03-16 15:25
 **/


@Configuration
@PropertySource("classpath:aliyun.properties")
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliYunProperties {
    private String accessKeyId;
    private String accessKeySecret;
}
