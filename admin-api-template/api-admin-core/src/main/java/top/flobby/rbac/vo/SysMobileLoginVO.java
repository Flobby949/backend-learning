package top.flobby.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 手机登录vo
 * @create : 2023-05-02 22:48
 **/

@Data
@Schema(description = "手机号登录vo")
public class SysMobileLoginVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "验证码")
    private String code;
}
