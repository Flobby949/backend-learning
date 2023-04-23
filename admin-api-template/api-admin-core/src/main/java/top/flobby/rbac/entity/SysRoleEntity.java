package top.flobby.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.mybatis.entity.BaseEntity;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 角色
 * @create : 2023-04-23 17:50
 **/

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}
