package top.flobby.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.mybatis.entity.BaseEntity;

/**
 * 角色菜单关系表实体类
 *
 * @author flobby
 */
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
