package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysRoleEntity;

/**
 * 角色管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
