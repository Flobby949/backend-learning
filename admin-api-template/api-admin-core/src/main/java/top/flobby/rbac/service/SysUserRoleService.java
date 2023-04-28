package top.flobby.rbac.service;


import top.flobby.mybatis.service.BaseService;
import top.flobby.rbac.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户角色关系
 *
 * @author flobby
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {

    /**
     * 获取角色id列表
     *
     * @param userId 用户id
     * @return {@link List}<{@link Long}>
     */
    List<Long> getRoleIdList(Long userId);
}