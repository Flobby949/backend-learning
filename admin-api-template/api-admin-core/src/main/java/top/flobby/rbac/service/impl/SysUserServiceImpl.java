package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysUserDao;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.service.SysUserService;

/**
 * 系统用户服务
 *
 * @author flobby
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

}
