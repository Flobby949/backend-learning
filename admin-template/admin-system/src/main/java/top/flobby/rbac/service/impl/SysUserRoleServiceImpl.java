package top.flobby.rbac.service.impl;


import org.springframework.stereotype.Service;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysUserRoleDao;
import top.flobby.rbac.entity.SysUserRoleEntity;
import top.flobby.rbac.service.SysUserRoleService;

/**
 * 用户角色关系服务
 *
 * @author mqxu
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}