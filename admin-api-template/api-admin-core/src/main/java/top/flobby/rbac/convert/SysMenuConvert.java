package top.flobby.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.rbac.entity.SysMenuEntity;
import top.flobby.rbac.vo.SysMenuVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 系统菜单实体转换
 * @create : 2023-04-23 19:45
 **/

@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenuEntity convert(SysMenuVO vo);

    SysMenuVO convert(SysMenuEntity entity);

    List<SysMenuVO> convertList(List<SysMenuEntity> list);

}
