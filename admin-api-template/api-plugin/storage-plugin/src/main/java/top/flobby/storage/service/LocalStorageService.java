package top.flobby.storage.service;

import org.springframework.util.FileCopyUtils;
import top.flobby.common.exception.ServerException;
import top.flobby.storage.properties.StorageProperties;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 本地存储
 * @create : 2023-05-03 00:33
 **/

public class LocalStorageService extends StorageService {

    public LocalStorageService(StorageProperties properties) {
        this.properties = properties;
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }


    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            File file = new File(properties.getLocal().getPath() + File.separator + path);
            // 没有目录，则自动创建目录
            File parent = file.getParentFile();
            if (parent != null && !parent.mkdirs() && !parent.isDirectory()) {
                throw new IOException("目录 '" + parent + "' 创建失败");
            }
            FileCopyUtils.copy(inputStream, Files.newOutputStream(file.toPath()));
        } catch (Exception e) {
            throw new ServerException("上传文件失败：", e);
        }
        return properties.getConfig().getDomain() + "/" + properties.getLocal().getUrl() + "/" + path;
    }
}
