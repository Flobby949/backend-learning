package top.flobby.storage.config;

import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.flobby.storage.enums.StorageTypeEnum;
import top.flobby.storage.properties.LocalStorageProperties;
import top.flobby.storage.properties.StorageProperties;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 本地资源映射
 * @create : 2023-05-03 00:34
 **/

@Configuration
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class LocalResourceConfiguration implements WebMvcConfigurer {
    @Resource
    private StorageProperties properties;

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        // 如果不是本地存储，则返回
        if (properties.getConfig().getType() != StorageTypeEnum.LOCAL) {
            return;
        }
        LocalStorageProperties local = properties.getLocal();
        registry.addResourceHandler("/" + local.getUrl() + "/**")
                .addResourceLocations("file:" + local.getPath() + "/");
    }
}
