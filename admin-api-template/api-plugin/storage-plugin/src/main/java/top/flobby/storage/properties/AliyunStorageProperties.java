package top.flobby.storage.properties;

import lombok.Data;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 阿里云配置
 * @create : 2023-05-03 00:32
 **/

@Data
public class AliyunStorageProperties {
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
