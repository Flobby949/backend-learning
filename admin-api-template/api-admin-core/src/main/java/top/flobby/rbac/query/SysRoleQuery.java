package top.flobby.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.common.query.Query;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 角色查询
 * @create : 2023-05-02 13:12
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysRoleQuery extends Query {
    @Schema(description = "角色名称")
    private String name;

}
