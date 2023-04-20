package top.flobby.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import top.flobby.common.utils.PageResult;
import top.flobby.convert.NoticeConvert;
import top.flobby.dao.NoticeDao;
import top.flobby.entity.Notice;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.query.NoticeQuery;
import top.flobby.service.NoticeService;
import top.flobby.vo.NoticeVO;

/**
 * @author : Flobby
 * @program : admin-template
 * @description :
 * @create : 2023-04-20 22:37
 **/

@Service
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, Notice> implements NoticeService {
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        IPage<Notice> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private Wrapper<Notice> getWrapper(NoticeQuery query) {
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()), Notice::getTitle, query.getTitle());
        return wrapper;
    }
}
