package top.flobby.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.rbac.entity.SysRoleEntity;
import top.flobby.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 角色转换
 * @create : 2023-05-02 13:14
 **/

@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleVO convert(SysRoleEntity entity);

    SysRoleEntity convert(SysRoleVO vo);

    List<SysRoleVO> convertList(List<SysRoleEntity> list);

}
