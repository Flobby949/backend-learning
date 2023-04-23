package top.flobby.rbac.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysRoleDao;
import top.flobby.rbac.entity.SysRoleEntity;
import top.flobby.rbac.service.SysRoleService;

/**
 * 系统角色服务
 *
 * @author flobby
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}