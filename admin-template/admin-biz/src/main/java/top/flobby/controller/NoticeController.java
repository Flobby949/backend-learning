package top.flobby.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.flobby.common.utils.PageResult;
import top.flobby.common.utils.Result;
import top.flobby.convert.NoticeConvert;
import top.flobby.query.NoticeQuery;
import top.flobby.service.NoticeService;
import top.flobby.vo.NoticeVO;

import java.util.List;

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
    @PreAuthorize("hasAuthority('sys:notice:page')")
    public Result<PageResult<NoticeVO>> page(@ParameterObject @Valid NoticeQuery query) {
        return Result.ok(noticeService.page(query));
    }

    @GetMapping("list")
    @Operation(summary = "通知列表")
    public Result<List<NoticeVO>> list() {
        return Result.ok(noticeService.getList());
    }

    @GetMapping("{id}")
    @Operation(summary = "通知信息")
    @PreAuthorize("hasAuthority('sys:notice:info')")
    public Result<NoticeVO> get(@PathVariable("id") Long id) {
        return Result.ok(NoticeConvert.INSTANCE.convert(noticeService.getById(id)));
    }

    @PostMapping
    @Operation(summary = "新增通知")
    @PreAuthorize("hasAuthority('sys:notice:save')")
    public Result<String> save(@RequestBody @Valid NoticeVO vo) {
        noticeService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改通知")
    @PreAuthorize("hasAuthority('sys:notice:update')")
    public Result<String> update(@RequestBody @Valid NoticeVO vo) {
        noticeService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除通知")
    @PreAuthorize("hasAuthority('sys:notice:delete')")
    public Result<String> delete(@PathVariable("id") Long id) {
        noticeService.delete(id);
        return Result.ok();
    }

    @DeleteMapping("batch")
    @Operation(summary = "批量删除通知")
    @PreAuthorize("hasAuthority('sys:notice:delete')")
    public Result<String> deletes(@RequestBody Long[] ids) {
        noticeService.deleteBatch(ids);
        return Result.ok();
    }
}
