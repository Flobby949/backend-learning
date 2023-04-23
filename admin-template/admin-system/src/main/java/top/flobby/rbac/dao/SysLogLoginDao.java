package top.flobby.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysLogLoginEntity;

/**
 * @author : JinChenXing
 * @program : admin-template
 * @description :
 * @create : 2023-04-23 13:46
 **/

@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {
}
