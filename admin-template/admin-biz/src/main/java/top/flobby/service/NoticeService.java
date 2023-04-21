package top.flobby.service;

import top.flobby.common.utils.PageResult;
import top.flobby.entity.NoticeEntity;
import top.flobby.mybatis.service.BaseService;
import top.flobby.query.NoticeQuery;
import top.flobby.vo.NoticeVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-template
 * @description :
 * @create : 2023-04-20 22:36
 **/

public interface NoticeService extends BaseService<NoticeEntity> {

    PageResult<NoticeVO> page(NoticeQuery query);

    /**
     * 得到列表
     *
     * @return {@link List}<{@link NoticeVO}>
     */
    List<NoticeVO> getList();

    /**
     * 保存
     *
     * @param vo 签证官
     */
    void save(NoticeVO vo);

    /**
     * 更新
     *
     * @param vo 签证官
     */
    void update(NoticeVO vo);

    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    void deleteBatch(Long[] ids);
}
