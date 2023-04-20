package top.flobby.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.common.utils.PageResult;
import top.flobby.common.utils.Result;
import top.flobby.query.NoticeQuery;
import top.flobby.service.NoticeService;
import top.flobby.vo.NoticeVO;

/**
 * @author : Flobby
 * @program : admin-template
 * @description :
 * @create : 2023-04-20 22:44
 **/

@RestController
@RequestMapping("notice")
@Tag(name = "通知管理")
@AllArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("page")
    @Operation(summary = "通知分页")
    public Result<PageResult<NoticeVO>> page(@ParameterObject @Valid NoticeQuery query) {
        return Result.ok(noticeService.page(query));
    }
}
