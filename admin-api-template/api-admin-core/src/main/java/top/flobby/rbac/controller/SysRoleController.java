package top.flobby.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.flobby.common.utils.PageResult;
import top.flobby.common.utils.Result;
import top.flobby.rbac.convert.SysRoleConvert;
import top.flobby.rbac.entity.SysRoleEntity;
import top.flobby.rbac.query.SysRoleQuery;
import top.flobby.rbac.service.SysRoleMenuService;
import top.flobby.rbac.service.SysRoleService;
import top.flobby.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 角色管理
 * @create : 2023-05-02 13:21
 **/

@RestController
@RequestMapping("sys/role")
@Tag(name = "角色管理")
@AllArgsConstructor
public class SysRoleController {
    private final SysRoleService sysRoleService;
    private final SysRoleMenuService sysRoleMenuService;

    @GetMapping("page")
    @Operation(summary = "角色分页")
    @PreAuthorize("hasAuthority('sys:role:page')")
    public Result<PageResult<SysRoleVO>> page(@ParameterObject @Valid SysRoleQuery query) {
        PageResult<SysRoleVO> page = sysRoleService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "角色信息")
    @PreAuthorize("hasAuthority('sys:role:info')")
    public Result<SysRoleVO> get(@PathVariable("id") Long id) {
        SysRoleEntity entity = sysRoleService.getById(id);
        SysRoleVO role = SysRoleConvert.INSTANCE.convert(entity);
        // 查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.getMenuIdList(id);
        role.setMenuIdList(menuIdList);
        return Result.ok(role);
    }

    @PostMapping
    @Operation(summary = "保存角色")
    @PreAuthorize("hasAuthority('sys:role:save')")
    public Result<String> save(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改角色")
    @PreAuthorize("hasAuthority('sys:role:update')")
    public Result<String> update(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除角色")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public Result<String> delete(@PathVariable("id") Long id) {
        sysRoleService.delete(id);
        return Result.ok();
    }

    @PostMapping("/menus/{roleId}")
    @Operation(summary = "分配权限给角色")
    @PreAuthorize("hasAuthority('sys:role:update')")
    public Result<String> setRoleMenus(@PathVariable("roleId") Long roleId, @RequestBody List<Long> menuIds) {
        sysRoleService.setRoleMenus(roleId, menuIds);
        return Result.ok();
    }

}
