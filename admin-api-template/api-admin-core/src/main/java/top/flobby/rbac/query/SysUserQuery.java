package top.flobby.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.common.query.Query;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 用户查询类
 * @create : 2023-04-28 12:41
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户信息查询参数")
public class SysUserQuery extends Query {

    @Schema(description = "用户信息")
    private String username;
    @Schema(description = "手机号")
    private String mobile;
    @Schema(description = "性别")
    private Integer gender;
}
