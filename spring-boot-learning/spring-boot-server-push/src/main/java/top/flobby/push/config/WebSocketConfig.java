package top.flobby.push.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 编写配置类，开启 Websocket 功能，没有 ssl
 * @create : 2023-04-17 15:39
 **/

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
