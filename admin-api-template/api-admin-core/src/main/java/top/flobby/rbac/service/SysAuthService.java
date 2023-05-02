package top.flobby.rbac.service;


import top.flobby.rbac.vo.SysAccountLoginVO;
import top.flobby.rbac.vo.SysMobileLoginVO;
import top.flobby.rbac.vo.SysTokenVO;

/**
 * 权限认证服务
 *
 * @author flobby
 */
public interface SysAuthService {
    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);

    SysTokenVO loginByMobile(SysMobileLoginVO login);

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @return boolean
     */
    boolean sendCode(String mobile);
}
