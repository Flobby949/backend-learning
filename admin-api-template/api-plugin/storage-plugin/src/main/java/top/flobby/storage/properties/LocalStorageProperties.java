package top.flobby.storage.properties;

import lombok.Data;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 本地存储配置
 * @create : 2023-05-03 00:31
 **/

@Data
public class LocalStorageProperties {
    /**
     * 本地存储路径
     */
    private String path;
    /**
     * 资源起始路径
     */
    private String url = "upload";
}
