package top.flobby.rbac.service.impl;


import org.springframework.stereotype.Service;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysUserRoleDao;
import top.flobby.rbac.entity.SysUserRoleEntity;
import top.flobby.rbac.service.SysUserRoleService;

import java.util.List;

/**
 * 用户角色关系服务
 *
 * @author flobby
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public List<Long> getRoleIdList(Long userId) {
        return baseMapper.selectRoleIdList(userId);
    }
}