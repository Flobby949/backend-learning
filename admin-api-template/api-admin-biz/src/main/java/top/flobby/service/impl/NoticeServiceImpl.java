package top.flobby.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flobby.common.utils.PageResult;
import top.flobby.convert.NoticeConvert;
import top.flobby.dao.NoticeDao;
import top.flobby.entity.NoticeEntity;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.query.NoticeQuery;
import top.flobby.service.NoticeService;
import top.flobby.vo.NoticeVO;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description :
 * @create : 2023-04-20 22:37
 **/

@Service
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<NoticeVO> getList() {
        return NoticeConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(new NoticeQuery())));
    }

    @Override
    public void save(NoticeVO vo) {
        baseMapper.insert(NoticeConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(NoticeVO vo) {
        updateById(NoticeConvert.INSTANCE.convert(vo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] ids) {
        removeByIds(Arrays.asList(ids));
    }

    private Wrapper<NoticeEntity> getWrapper(NoticeQuery query) {
        LambdaQueryWrapper<NoticeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()), NoticeEntity::getTitle, query.getTitle())
                .like(StrUtil.isNotBlank(query.getContent()), NoticeEntity::getContent, query.getContent());
        return wrapper;
    }
}
