package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysUserRoleEntity;


/**
 * 用户角色关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

}