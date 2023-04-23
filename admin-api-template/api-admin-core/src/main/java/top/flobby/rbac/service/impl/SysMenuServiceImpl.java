package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysMenuDao;
import top.flobby.rbac.entity.SysMenuEntity;
import top.flobby.rbac.service.SysMenuService;


/**
 * 菜单管理服务
 *
 * @author flobby
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}