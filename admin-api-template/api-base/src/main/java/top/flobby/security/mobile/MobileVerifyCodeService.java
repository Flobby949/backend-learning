package top.flobby.security.mobile;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 手机短信登录，验证码效验
 * @create : 2023-05-02 22:43
 **/

public interface MobileVerifyCodeService {

    boolean verifyCode(String mobile, String code);
}
