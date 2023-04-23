package top.flobby.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : Swagger 配置
 * @create : 2023-04-23 17:00
 **/
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"top.flobby"};
        return GroupedOpenApi.builder().group("Admin Template")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        Contact contact = new Contact();
        contact.setName("2541226493@qq.com.com");

        return new OpenAPI().info(new Info()
                .title("管理后端接口文档")
                .description("管理后端接口文档")
                .contact(contact)
                .version("1.0.0")
                .termsOfService("http://www.flobby.top"));
    }

}