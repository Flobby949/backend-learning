package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.flobby.common.constant.Constant;
import top.flobby.common.utils.TreeUtils;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.convert.SysMenuConvert;
import top.flobby.rbac.dao.SysMenuDao;
import top.flobby.rbac.entity.SysMenuEntity;
import top.flobby.rbac.enums.SuperAdminEnum;
import top.flobby.rbac.service.SysMenuService;
import top.flobby.rbac.vo.SysMenuVO;
import top.flobby.security.user.UserDetail;

import java.util.List;


/**
 * 菜单管理服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuVO> getMenuList(Integer type) {
        List<SysMenuEntity> menuList = baseMapper.getMenuList(type);
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList), Constant.ROOT);
    }

    @Override
    public List<SysMenuVO> getUserMenuList(UserDetail user, Integer type) {
        List<SysMenuEntity> menuList;
        // 系统管理员，拥有最高权限
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            menuList = baseMapper.getMenuList(type);
        } else {
            menuList = baseMapper.getUserMenuList(user.getId(), type);
        }
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList));
    }

}