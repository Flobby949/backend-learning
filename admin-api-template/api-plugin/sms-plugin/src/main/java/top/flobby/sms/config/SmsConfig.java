package top.flobby.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 短信配置
 * @create : 2023-05-02 22:05
 **/

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.sms") // 配置文件的前缀
public class SmsConfig {
    /**
     * 平台  0：阿里云   1：腾讯云
     */
    private Integer platform;

    /**
     * 短信签名
     */
    private String signName;

    /**
     * 短信模板
     */
    private String templateId;

    /**
     * AccessKey
     */
    private String accessKey;

    /**
     * SecretKey
     */
    private String secretKey;

}
