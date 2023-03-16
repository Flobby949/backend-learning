package top.flobby.spring.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.flobby.spring.entity.RestResult;
import top.flobby.spring.prop.FileResource;
import top.flobby.spring.service.FileUploadService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-16 16:14
 **/

@RestController
@AllArgsConstructor
public class UploadController {
    private final FileUploadService fileUploadService;
    private final FileResource fileResource;

    @PostMapping("upload")
    public RestResult upload(@RequestParam("file") MultipartFile file) {
        Map<String, Object> resultMap = new HashMap<>(3);
        //声明图片地址，返回到前端
        String path = null;
        //判断文件不能为空
        if (file != null) {
            //获取文件上传名称
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            //调用上传服务，得到上传后文件名
            path = fileUploadService.uploadFile(file);
        }
        if (StringUtils.isNotBlank(path)) {
            //拼接上服务器地址前缀，得到最终返回给前端的url
            path = fileResource.getOssHost() + path;
        }
        resultMap.put("path", path);
        return RestResult.builder()
                .code(1)
                .msg("搜索成功")
                .data(resultMap)
                .build();
    }
}
