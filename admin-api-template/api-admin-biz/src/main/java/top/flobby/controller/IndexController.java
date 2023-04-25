package top.flobby.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.common.utils.Result;
import top.flobby.service.IndexService;
import top.flobby.vo.BarVO;
import top.flobby.vo.LabelVO;
import top.flobby.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 首页接口
 * @create : 2023-04-25 13:53
 **/

@RestController
@AllArgsConstructor
@RequestMapping("sys/index")
@Tag(name = "首页统计")
public class IndexController {
    private final IndexService indexService;

    @GetMapping("statistics1")
    @Operation(summary = "统计组件1")
    public Result<List<PanelVO>> getStatistics1() {
        return Result.ok(indexService.statistics1());
    }

    @GetMapping("statistics2")
    @Operation(summary = "统计组件2")
    public Result<BarVO> getStatistics2() {
        return Result.ok(indexService.statistics2());
    }

    @GetMapping("statistics3")
    @Operation(summary = "统计组件3")
    public Result<Map<String, List<LabelVO>>> getStatistics3() {
        return Result.ok(indexService.statistics3());
    }
}
