package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysUserDao;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.service.SysUserService;

/**
 * 系统用户服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }
}
