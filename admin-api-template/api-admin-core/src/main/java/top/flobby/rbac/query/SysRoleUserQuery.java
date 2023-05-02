package top.flobby.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 分配角色查询
 * @create : 2023-05-02 13:13
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "分配角色查询")
public class SysRoleUserQuery extends SysUserQuery {
    @Schema(description = "角色ID")
    private Long roleId;

}
