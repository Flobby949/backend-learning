package top.flobby.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.common.query.Query;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 菜单查询
 * @create : 2023-05-02 13:13
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysMenuQuery extends Query {
    @Schema(description = "菜单类型")
    private Integer type;

}
