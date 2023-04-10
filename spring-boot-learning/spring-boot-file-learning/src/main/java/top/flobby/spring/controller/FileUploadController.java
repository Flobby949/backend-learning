package top.flobby.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-10 13:59
 **/

@RestController
@RequestMapping("file")
public class FileUploadController {
    @Value("${web.custom-file-upload}")
    private String uploadPath;

    DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @PostMapping("upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        // 每天创建一个当天子目录，在
        String date = df.format(new Date());
        File fileDir = new File(uploadPath + date);
        if (!fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        // 上传文件重命名,避免冲突
        String originFileName = file.getOriginalFilename();
        if (StringUtils.isBlank(originFileName)) {
            // 请求失败
            return "";
        }
        String suffix = originFileName.substring(originFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + suffix;
        // 上传：文件复制搬运
        file.transferTo(new File(fileDir, newFileName));
        // 拼接返回上传文件访问路径
        // http://localhost:8080/20230410/ef94d681-3a40-43cb-b127-a2c0a35a6887.jpg
        return String.format("%s://%s:%s/%s/%s",
                request.getScheme(),
                request.getServerName(),
                request.getServerPort(),
                date, newFileName);
    }

}
