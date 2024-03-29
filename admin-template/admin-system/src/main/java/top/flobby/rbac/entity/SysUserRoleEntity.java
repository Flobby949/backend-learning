package top.flobby.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.mybatis.entity.BaseEntity;

/**
 * 系统用户角色关系表实体类
 *
 * @author flobby
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 用户ID
	 */
	private Long userId;

}
