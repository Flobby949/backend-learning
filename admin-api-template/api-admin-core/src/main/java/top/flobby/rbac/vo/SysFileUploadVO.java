package top.flobby.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 文件上传vo
 * @create : 2023-05-03 01:00
 **/

@Data
@Schema(description = "文件上传vo")
public class SysFileUploadVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "文件名称")
    private String name;

    @Schema(description = "文件地址")
    private String url;

    @Schema(description = "文件大小")
    private Long size;

    @Schema(description = "存储平台")
    private String platform;
}