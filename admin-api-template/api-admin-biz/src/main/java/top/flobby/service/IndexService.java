package top.flobby.service;

import top.flobby.vo.BarVO;
import top.flobby.vo.LabelVO;
import top.flobby.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 首页服务
 * @create : 2023-04-25 13:50
 **/

public interface IndexService {
    /**
     * 首页统计1：项目路主要数据统计面板
     *
     * @return {@link List}<{@link PanelVO}>
     */
    List<PanelVO> statistics1();

    /**
     * 柱状图
     *
     * @return {@link BarVO}
     */
    BarVO statistics2();

    /**
     * 分类统计标签
     *
     * @return {@link Map}<{@link String}, {@link List}<{@link LabelVO}>>
     */
    Map<String, List<LabelVO>> statistics3();
}
