package top.flobby.service;

import top.flobby.common.utils.PageResult;
import top.flobby.entity.Notice;
import top.flobby.mybatis.service.BaseService;
import top.flobby.query.NoticeQuery;
import top.flobby.vo.NoticeVO;

/**
 * @author : Flobby
 * @program : admin-template
 * @description :
 * @create : 2023-04-20 22:36
 **/

public interface NoticeService extends BaseService<Notice> {

    PageResult<NoticeVO> page(NoticeQuery query);
}
