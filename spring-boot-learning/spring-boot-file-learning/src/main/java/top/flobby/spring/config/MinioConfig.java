package top.flobby.spring.config;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : minio 配置工具
 * @create : 2023-04-10 15:10
 **/

@Configuration
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.assessKey}")
    private String assessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient minioClient;

    @PostConstruct
    public void init() {
        minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(assessKey, secretKey)
                .build();
    }

    /**
     * bucket 是否存在
     *
     * @param bucketName bucket名称
     * @return boolean
     * @throws Exception 异常
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 创建 bucket
     *
     * @param bucketName bucket名称
     * @throws Exception 异常
     */
    public void makeBucket(String bucketName) throws Exception {
        boolean exists = bucketExists(bucketName);
        // 不存在
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 上传文件
     *
     * @param bucket     bucket
     * @param objectName 文件对象名称
     * @param filePath   待上传文件路径
     * @return {@link ObjectWriteResponse}
     * @throws Exception 异常
     */
    public ObjectWriteResponse uploadObject(String bucket, String objectName, String filePath) throws Exception {
        return minioClient.uploadObject(UploadObjectArgs.builder()
                .bucket(bucket)
                .object(objectName)
                .filename(filePath)
                .build());
    }

    /**
     * 文件流上传
     *
     * @param bucket      bucket
     * @param objectName  对象名称
     * @param inputStream 输入流
     * @return {@link ObjectWriteResponse}
     * @throws Exception 异常
     */
    public ObjectWriteResponse putObject(String bucket, String objectName, InputStream inputStream) throws Exception {
        return minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucket)
                .object(objectName)
                .stream(inputStream, -1, 10485760)
                .build());
    }

    /**
     * 删除文件
     *
     * @param bucket     bucket
     * @param objectName 对象名称
     * @throws Exception 异常
     */
    public void removeObject(String bucket, String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucket)
                .object(objectName)
                .build());
    }

}
