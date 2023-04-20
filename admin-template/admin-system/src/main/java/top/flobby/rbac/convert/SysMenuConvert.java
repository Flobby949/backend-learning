package top.flobby.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.rbac.entity.SysMenuEntity;
import top.flobby.rbac.vo.SysMenuVO;

import java.util.List;

/**
 * 系统菜单实体转换
 *
 * @author moqi
 */
@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenuEntity convert(SysMenuVO vo);

    SysMenuVO convert(SysMenuEntity entity);

    List<SysMenuVO> convertList(List<SysMenuEntity> list);

}
