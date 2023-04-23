package top.flobby.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.flobby.common.utils.Result;
import top.flobby.rbac.service.SysAuthService;
import top.flobby.rbac.service.SysCaptchaService;
import top.flobby.rbac.vo.SysAccountLoginVO;
import top.flobby.rbac.vo.SysCaptchaVO;
import top.flobby.rbac.vo.SysTokenVO;
import top.flobby.security.utils.TokenUtils;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 认证接口
 * @create : 2023-04-23 18:34
 **/

@RestController
@RequestMapping("sys/auth")
@Tag(name = "认证管理")
@AllArgsConstructor
public class SysAuthController {
    private final SysAuthService sysAuthService;
    private final SysCaptchaService sysCaptchaService;

    @GetMapping("captcha")
    @Operation(summary = "验证码")
    public Result<SysCaptchaVO> captcha() {
        SysCaptchaVO captchaVO = sysCaptchaService.generate();
        return Result.ok(captchaVO);
    }

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<SysTokenVO> login(@RequestBody SysAccountLoginVO login) {
        SysTokenVO token = sysAuthService.loginByAccount(login);
        return Result.ok(token);
    }

    @PostMapping("logout")
    @Operation(summary = "退出")
    public Result<String> logout(HttpServletRequest request) {
        sysAuthService.logout(TokenUtils.getAccessToken(request));
        return Result.ok();
    }
}
