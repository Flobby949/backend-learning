package top.flobby.spring.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MinioConfigTest {

    @Resource
    private MinioConfig minioConfig;

    @Test
    void makeBucket() throws Exception {
        minioConfig.makeBucket("bucket-test");
    }

    @Test
    void uploadObject() throws Exception {
        minioConfig.uploadObject("bucket-test", "avatar/1.jpg",
                "E:\\java-projects\\backend-learning\\spring-boot-learning\\spring-boot-file-learning\\fileUpload\\20230410\\7a00c700-6c93-478d-9b32-706d2daf7417.jpg");
    }

    @Test
    void putObject() throws Exception {
        minioConfig.putObject("bucket-test", "avatar/2.jpg",
                new FileInputStream("E:\\java-projects\\backend-learning\\spring-boot-learning\\spring-boot-file-learning\\fileUpload\\20230410\\7a00c700-6c93-478d-9b32-706d2daf7417.jpg"));
    }

    @Test
    void removeObject() throws Exception {
        minioConfig.removeObject("bucket-test", "avatar/1.jpg");
    }
}