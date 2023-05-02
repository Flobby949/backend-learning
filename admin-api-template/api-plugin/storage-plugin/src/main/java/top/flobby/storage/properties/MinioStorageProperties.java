package top.flobby.storage.properties;

import lombok.Data;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : minio配置
 * @create : 2023-05-03 00:32
 **/

@Data
public class MinioStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
