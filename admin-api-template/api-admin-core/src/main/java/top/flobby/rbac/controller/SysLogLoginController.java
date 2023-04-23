package top.flobby.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.common.utils.PageResult;
import top.flobby.common.utils.Result;
import top.flobby.rbac.query.SysLogLoginQuery;
import top.flobby.rbac.service.SysLogLoginService;
import top.flobby.rbac.vo.SysLogLoginVO;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 登录日志接口
 * @create : 2023-04-23 14:15
 **/

@RestController
@Tag(name = "登录日志")
@AllArgsConstructor
@RequestMapping("sys/log")
public class SysLogLoginController {
    private final SysLogLoginService logLoginService;

    @GetMapping("page")
    @Operation(summary = "分页获取登录日志")
    @PreAuthorize("hasAnyAuthority('sys:log:page')")
    public Result<PageResult<SysLogLoginVO>> page(@ParameterObject @Valid SysLogLoginQuery query) {
        return Result.ok(logLoginService.page(query));
    }
}
