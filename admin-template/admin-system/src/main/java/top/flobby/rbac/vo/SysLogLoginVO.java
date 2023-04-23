package top.flobby.rbac.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.flobby.common.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : Flobby
 * @program : admin-template
 * @description : 登录日志VO
 * @create : 2023-04-23 13:41
 **/

@Data
@Schema(description = "菜单")
public class SysLogLoginVO  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "ip")
    private String ip;
    @Schema(description = "地址")
    private String address;
    @Schema(description = "UA")
    private String userAgent;
    /**
     *  登录状态  0：失败   1：成功
     */
    @Schema(description = "登录状态：0：失败   1：成功")
    private Integer status;
    /**
     *  操作信息   0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误
     */
    @Schema(description = "操作信息：0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误")
    private Integer operation;
    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;
}
