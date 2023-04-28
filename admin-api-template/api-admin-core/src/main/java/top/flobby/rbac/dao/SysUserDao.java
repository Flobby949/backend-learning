package top.flobby.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.flobby.common.enums.DeleteFlagEnum;
import top.flobby.mybatis.dao.BaseDao;
import top.flobby.rbac.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统用户 dao
 *
 * @author flobby
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    default SysUserEntity getByUsername(String username){
        return this.selectOne(new QueryWrapper<SysUserEntity>()
                .eq("username", username)
                .eq("deleted", DeleteFlagEnum.NOT_DELETED.getValue()));
    }

    /**
     * 条件查询
     *
     * @param params 参数
     * @return {@link List}<{@link SysUserEntity}>
     */
    List<SysUserEntity> getList(Map<String, Object> params);

    /**
     * 通过id查询用户信息
     *
     * @param id id
     * @return {@link SysUserEntity}
     */
    default SysUserEntity getById(Long id){
        return this.selectOne(new QueryWrapper<SysUserEntity>()
                .eq("id", id)
                .eq("deleted", DeleteFlagEnum.NOT_DELETED.getValue()));
    }

    /**
     * 通过电话查询用户
     *
     * @param phone 电话
     * @return {@link SysUserEntity}
     */
    default SysUserEntity getByPhone(String phone) {
        return this.selectOne(new QueryWrapper<SysUserEntity>()
                .eq("mobile", phone)
                .eq("deleted", DeleteFlagEnum.NOT_DELETED.getValue()));
    }
}