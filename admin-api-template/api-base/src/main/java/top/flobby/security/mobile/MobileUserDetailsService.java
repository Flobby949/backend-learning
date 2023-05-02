package top.flobby.security.mobile;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 手机短信登录，UserDetailsService
 * @create : 2023-05-02 22:43
 **/

public interface MobileUserDetailsService {

    /**
     * 通过手机号加载用户信息
     *
     * @param mobile 手机号
     * @return 用户信息
     * @throws UsernameNotFoundException 不存在异常
     */
    UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException;
}
