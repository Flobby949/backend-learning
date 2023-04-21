package top.flobby.dao;

import org.apache.ibatis.annotations.Mapper;
import top.flobby.entity.NoticeEntity;
import top.flobby.mybatis.dao.BaseDao;

/**
 * @author : JinChenXing
 * @program : admin-template
 * @description :
 * @create : 2023-04-20 22:03
 **/

@Mapper
public interface NoticeDao extends BaseDao<NoticeEntity> {
}
