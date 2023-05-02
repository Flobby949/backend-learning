package top.flobby.storage.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import top.flobby.storage.enums.StorageTypeEnum;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 存储配置项
 * @create : 2023-05-03 00:31
 **/

@Data
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
    /**
     * 是否开启存储
     */
    private boolean enabled;
    /**
     * 通用配置项
     */
    private StorageConfig config;
    /**
     * 本地配置项
     */
    private LocalStorageProperties local;
    /**
     * 阿里云配置项
     */
    private AliyunStorageProperties aliyun;
    /**
     * Minio配置项
     */
    private MinioStorageProperties minio;

    @Data
    public static class StorageConfig {
        /**
         * 访问域名
         */
        private String domain;
        /**
         * 配置路径前缀
         */
        private String prefix;
        /**
         * 存储类型
         */
        private StorageTypeEnum type;
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.local")
    public LocalStorageProperties localStorageProperties() {
        return new LocalStorageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.aliyun")
    public AliyunStorageProperties aliyunStorageProperties() {
        return new AliyunStorageProperties();
    }


    @Bean
    @ConfigurationProperties(prefix = "storage.minio")
    public MinioStorageProperties minioStorageProperties() {
        return new MinioStorageProperties();
    }

}
