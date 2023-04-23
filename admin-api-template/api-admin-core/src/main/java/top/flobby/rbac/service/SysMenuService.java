package top.flobby.rbac.service;


import top.flobby.mybatis.service.BaseService;
import top.flobby.rbac.entity.SysMenuEntity;
import top.flobby.rbac.vo.SysMenuVO;
import top.flobby.security.user.UserDetail;

import java.util.List;
import java.util.Set;

/**
 * 菜单管理
 *
 * @author flobby
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {
    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
}
