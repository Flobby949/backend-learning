package top.flobby.rbac.event;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import top.flobby.common.constant.Constant;
import top.flobby.rbac.enums.LoginOperationEnum;
import top.flobby.rbac.service.SysLogLoginService;
import top.flobby.security.user.UserDetail;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 日志事件
 * @create : 2023-04-23 14:32
 **/

@Component
@AllArgsConstructor
public class AuthenticationEvents {
    private final SysLogLoginService logLoginService;

    /**
     * 登录成功
     *
     * @param event 事件
     */
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) {
        // 获取用户信息
        UserDetail userDetail = (UserDetail) event.getAuthentication().getPrincipal();
        // 保存日志
        logLoginService.save(userDetail.getUsername(), Constant.SUCCESS, LoginOperationEnum.LOGIN_SUCCESS.getValue());
    }

    /**
     * 登录失败
     *
     * @param event 事件
     */
    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event) {
        // 获取用户信息
        UserDetail userDetail = (UserDetail) event.getAuthentication().getPrincipal();
        // 保存日志
        logLoginService.save(userDetail.getUsername(), Constant.FAIL, LoginOperationEnum.ACCOUNT_FAIL.getValue());
    }

}
