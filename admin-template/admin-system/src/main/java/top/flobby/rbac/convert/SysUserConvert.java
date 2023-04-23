package top.flobby.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.vo.SysUserVO;
import top.flobby.security.user.UserDetail;


/**
 * 系统用户实体转换
 *
 * @author flobby
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(UserDetail userDetail);

    UserDetail convertDetail(SysUserEntity entity);

}
