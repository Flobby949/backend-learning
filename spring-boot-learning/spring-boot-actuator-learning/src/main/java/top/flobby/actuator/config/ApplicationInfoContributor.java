package top.flobby.actuator.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义 info
 * @create : 2023-04-18 15:38
 **/

@Component
public class ApplicationInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName", "spring-boot-actuator-learning");
        Map<String, Object> data = new HashMap<>();
        data.put("author", "flobby");
        data.put("version", "1.0.0");
        builder.withDetails(data);
    }
}
