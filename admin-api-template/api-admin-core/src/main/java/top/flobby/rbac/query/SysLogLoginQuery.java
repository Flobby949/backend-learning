package top.flobby.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.common.query.Query;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description :
 * @create : 2023-04-23 13:50
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "日志信息查询参数")
public class SysLogLoginQuery extends Query {

    @Schema(description = "用户信息")
    private String username;
    @Schema(description = "登录地点")
    private String address;
    @Schema(description = "登录状态")
    private Integer status;
}
