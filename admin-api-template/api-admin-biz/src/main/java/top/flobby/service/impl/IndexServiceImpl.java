package top.flobby.service.impl;

import org.springframework.stereotype.Service;
import top.flobby.service.IndexService;
import top.flobby.vo.BarVO;
import top.flobby.vo.LabelVO;
import top.flobby.vo.PanelVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 实现类
 * @create : 2023-04-25 13:53
 **/

@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public List<PanelVO> statistics1() {
        return List.of(PanelVO.builder()
                        .title("支付订单")
                        .value(499)
                        .unit("年")
                        .unitColor("success")
                        .subTitle("总支付订单")
                        .subValue(4999)
                        .subUnit("年")
                        .build(),
                PanelVO.builder()
                        .title("订单量")
                        .value(456)
                        .unit("周")
                        .unitColor("danger")
                        .subTitle("总订单量")
                        .subValue(4681)
                        .subUnit("年")
                        .build(),
                PanelVO.builder()
                        .title("销售额(万元)")
                        .value(454)
                        .unit("年")
                        .unitColor("primary")
                        .subTitle("总销售额(万元)")
                        .subValue(6543)
                        .subUnit("年")
                        .build(),
                PanelVO.builder()
                        .title("新增用户")
                        .value(15)
                        .unit("月")
                        .unitColor("warning")
                        .subTitle("总用户数")
                        .subValue(919)
                        .subUnit("年")
                        .build());
    }

    @Override
    public BarVO statistics2() {
        List<String> x = List.of("00", "23", "22", "21", "20", "19", "18", "17", "16", "15");
        List<Integer> y = List.of(0, 2, 2, 1, 0, 9, 1, 7, 16, 5);
        return BarVO.builder().x(x).y(y).build();
    }

    @Override
    public Map<String, List<LabelVO>> statistics3() {
        List<LabelVO> goods = List.of(
                new LabelVO("审核中", 5),
                new LabelVO("销售中", 17),
                new LabelVO("已下架", 8),
                new LabelVO("库存预警", 2)
        );
        List<LabelVO> orders = List.of(
                new LabelVO("代付款", 2),
                new LabelVO("代发货", 13),
                new LabelVO("已发货", 32),
                new LabelVO("退款中", 5)
        );
        Map<String, List<LabelVO>> map = new HashMap<>();
        map.put("goods", goods);
        map.put("orders", orders);
        return map;
    }
}
