package top.flobby.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.rbac.entity.SysLogLoginEntity;
import top.flobby.rbac.vo.SysLogLoginVO;

import java.util.List;

/**
 * @author : JinChenXing
 * @program : admin-template
 * @description : 日志类型转换
 * @create : 2023-04-23 14:07
 **/

@Mapper
public interface SysLogLoginConvert {

    SysLogLoginConvert INSTANCE = Mappers.getMapper(SysLogLoginConvert.class);

    SysLogLoginEntity convert(SysLogLoginVO vo);

    SysLogLoginVO convert(SysLogLoginEntity entity);

    List<SysLogLoginVO> convertList(List<SysLogLoginEntity> list);

}
