package top.flobby.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.flobby.entity.Notice;
import top.flobby.vo.NoticeVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-template
 * @description :
 * @create : 2023-04-20 22:33
 **/

@Mapper
public interface NoticeConvert {
    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    NoticeVO convert(NoticeConvert entity);

    Notice convert(NoticeVO vo);

    List<NoticeVO> convertList(List<Notice> list);
}
