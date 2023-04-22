package top.flobby.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.common.utils.Result;
import top.flobby.rbac.convert.SysUserConvert;
import top.flobby.rbac.service.SysMenuService;
import top.flobby.rbac.service.SysUserService;
import top.flobby.rbac.vo.SysAuthVO;
import top.flobby.rbac.vo.SysUserPasswordVO;
import top.flobby.security.user.SecurityUser;
import top.flobby.security.user.UserDetail;


/**
 * 用户管理接口
 *
 * @author mqxu
 */
@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;
    private final SysMenuService sysMenuService;

    @PostMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<SysAuthVO> info() {
        UserDetail userDetail = SecurityUser.getUser();
        SysAuthVO authVO = new SysAuthVO();
        authVO.setUser(SysUserConvert.INSTANCE.convert(userDetail));
        authVO.setNav(sysMenuService.getUserMenuList(userDetail, 0));
        authVO.setAuthority(sysMenuService.getAuthority(userDetail));
        return Result.ok(authVO);
    }

    @PostMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> password(@RequestBody @Valid SysUserPasswordVO vo) {
        // 原密码不正确
        UserDetail user = SecurityUser.getUser();
        if (!passwordEncoder.matches(vo.getOldPassword(), user.getPassword())) {
            return Result.error("原密码不正确");
        }
        // 修改密码
        sysUserService.updatePassword(user.getId(), passwordEncoder.encode(vo.getNewPassword()));
        return Result.ok();
    }

}
