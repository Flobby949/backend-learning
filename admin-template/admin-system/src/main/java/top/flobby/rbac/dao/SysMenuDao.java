package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysMenuEntity;

import java.util.List;


/**
 * 菜单管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {
    /**
     * 查询所有菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuEntity> getMenuList(@Param("type") Integer type);

    /**
     * 查询用户菜单列表
     *
     * @param userId 用户ID
     * @param type 菜单类型
     */
    List<SysMenuEntity> getUserMenuList(@Param("userId") Long userId, @Param("type") Integer type);


}
