package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysUserRoleEntity;

import java.util.List;


/**
 * 用户角色关系 dao
 *
 * @author flobby
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

    /**
     * 获取角色id列表
     *
     * @param userId 用户id
     * @return {@link List}<{@link Long}>
     */
    List<Long> selectRoleIdList(@Param("id") Long userId);
}