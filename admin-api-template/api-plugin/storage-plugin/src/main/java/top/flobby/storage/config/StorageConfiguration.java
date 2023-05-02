package top.flobby.storage.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.flobby.storage.enums.StorageTypeEnum;
import top.flobby.storage.properties.StorageProperties;
import top.flobby.storage.service.AliyunStorageService;
import top.flobby.storage.service.LocalStorageService;
import top.flobby.storage.service.MinioStorageService;
import top.flobby.storage.service.StorageService;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 存储配置文件
 * @create : 2023-05-03 00:35
 **/

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class StorageConfiguration {

    @Bean
    public StorageService storageService(StorageProperties properties) {
        if (properties.getConfig().getType() == StorageTypeEnum.LOCAL) {
            return new LocalStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.ALIYUN) {
            return new AliyunStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.MINIO) {
            return new MinioStorageService(properties);
        }
        return null;
    }
}
