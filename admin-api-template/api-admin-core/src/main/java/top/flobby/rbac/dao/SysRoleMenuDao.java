package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysRoleMenuEntity;

import java.util.List;


/**
 * 角色与菜单对应关系 dao
 *
 * @author flobby
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> getMenuIdList(@Param("roleId") Long roleId);
}
