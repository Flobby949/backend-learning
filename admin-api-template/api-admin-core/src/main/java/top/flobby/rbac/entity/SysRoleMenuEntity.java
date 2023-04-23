package top.flobby.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.mybatis.entity.BaseEntity;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 角色菜单关联
 * @create : 2023-04-23 17:51
 **/

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

}
