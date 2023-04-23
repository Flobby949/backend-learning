package top.flobby.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.common.utils.Result;
import top.flobby.rbac.convert.SysUserConvert;
import top.flobby.rbac.service.SysMenuService;
import top.flobby.rbac.vo.SysAuthVO;
import top.flobby.rbac.vo.SysUserVO;
import top.flobby.security.user.SecurityUser;
import top.flobby.security.user.UserDetail;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 系统用户接口
 * @create : 2023-04-23 19:47
 **/

@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysMenuService sysMenuService;

    @PostMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<SysAuthVO> info() {
        SysAuthVO vo = new SysAuthVO();
        UserDetail userDetail = SecurityUser.getUser();
        //1 获得用户详细信息，转成 vo
        SysUserVO user = SysUserConvert.INSTANCE.convert(userDetail);
        vo.setUser(user);
        //2 获取用户导航菜单
        vo.setNav(sysMenuService.getUserMenuList(userDetail, 0));
        //3 获得用户授权信息
        vo.setAuthority(sysMenuService.getUserAuthority(userDetail));
        return Result.ok(vo);
    }
}