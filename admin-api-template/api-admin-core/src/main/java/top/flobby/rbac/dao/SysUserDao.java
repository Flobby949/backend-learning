package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysUserEntity;

/**
 * 系统用户 dao
 *
 * @author flobby
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

}