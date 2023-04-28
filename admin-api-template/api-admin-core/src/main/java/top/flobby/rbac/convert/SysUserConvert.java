package top.flobby.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.vo.SysUserExcelVO;
import top.flobby.rbac.vo.SysUserVO;
import top.flobby.security.user.UserDetail;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 系统用户实体转换
 * @create : 2023-04-23 18:13
 **/

@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(SysUserEntity entity);

    SysUserEntity convert(SysUserVO vo);

    SysUserVO convert(UserDetail userDetail);

    UserDetail convertDetail(SysUserEntity entity);

    List<SysUserVO> convertList(List<SysUserEntity> list);

    List<SysUserExcelVO> covert2List(List<SysUserEntity> list);

    List<SysUserEntity> convertListEntity(List<SysUserExcelVO> list);

}
