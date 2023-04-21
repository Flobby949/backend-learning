package top.flobby.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.flobby.common.utils.Result;
import top.flobby.rbac.enums.MenuTypeEnum;
import top.flobby.rbac.service.SysMenuService;
import top.flobby.rbac.vo.SysMenuVO;
import top.flobby.security.user.SecurityUser;
import top.flobby.security.user.UserDetail;

import java.util.List;
import java.util.Set;

/**
 * 菜单管理
 *
 * @author mqxu
 */
@RestController
@RequestMapping("sys/menu")
@Tag(name = "菜单管理")
@AllArgsConstructor
public class SysMenuController {
    private final SysMenuService sysMenuService;

    @GetMapping("nav")
    @Operation(summary = "用户菜单导航")
    public Result<List<SysMenuVO>> nav() {
        UserDetail user = SecurityUser.getUser();
        List<SysMenuVO> list = sysMenuService.getUserMenuList(user, MenuTypeEnum.MENU.getValue());

        return Result.ok(list);
    }

    @GetMapping("list")
    @Operation(summary = "菜单列表")
    @Parameter(name = "type", description = "菜单类型 0：菜单 1：按钮  2：接口  null：全部")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public Result<List<SysMenuVO>> list(Integer type) {
        List<SysMenuVO> list = sysMenuService.getMenuList(type);

        return Result.ok(list);
    }

    @GetMapping("authority")
    @Operation(summary = "用户权限集合")
    public Result<Set<String>> authority() {
        UserDetail user = SecurityUser.getUser();
        Set<String> authority = sysMenuService.getAuthority(user);
        return Result.ok(authority);
    }
}