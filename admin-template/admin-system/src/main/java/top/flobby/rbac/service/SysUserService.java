package top.flobby.rbac.service;


import top.flobby.mybatis.service.BaseService;
import top.flobby.rbac.entity.SysUserEntity;

/**
 * 用户管理
 *
 * @author flobby
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

}
