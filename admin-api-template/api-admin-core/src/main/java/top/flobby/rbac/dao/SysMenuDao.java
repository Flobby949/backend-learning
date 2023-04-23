package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysMenuEntity;


/**
 * 菜单管理 dao
 *
 * @author flobby
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

}
