package top.flobby.spring.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.flobby.spring.prop.AliYunProperties;
import top.flobby.spring.prop.FileResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-16 15:31
 **/

@Service
@AllArgsConstructor
public class FileUploadService {
    private final AliYunProperties aliYunProperties;
    private final FileResource fileResource;

    public String uploadFile(MultipartFile file) {
        //读入配置文件信息
        String endpoint = fileResource.getEndpoint();
        String accessKeyId = aliYunProperties.getAccessKeyId();
        String accessKeySecret = aliYunProperties.getAccessKeySecret();
        //创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String fileName = file.getOriginalFilename();
        //分隔文件名，获取文件后缀
        assert fileName != null;
        String[] fileNameArr = fileName.split("\\.");
        String suffix = fileNameArr[fileNameArr.length - 1];
        //拼接得到新的上传文件名
        String uploadFileName = fileResource.getObjectName() + UUID.randomUUID().toString() + "." + suffix;
        //上传网络需要的字节流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            System.err.println("上传文件出现异常");
        }
        //执行阿里云上传文件操作
        ossClient.putObject(fileResource.getBucketName(), uploadFileName, inputStream);
        //关闭OSSClient
        ossClient.shutdown();
        return uploadFileName;
    }
}
