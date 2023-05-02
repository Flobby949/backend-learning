package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.flobby.rbac.dao.SysUserDao;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.service.SysUserDetailsService;
import top.flobby.security.mobile.MobileUserDetailsService;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 实现类
 * @create : 2023-05-02 23:00
 **/

@Service
@AllArgsConstructor
public class MobileUserDetailsServiceImpl implements MobileUserDetailsService {
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        SysUserEntity userEntity = sysUserDao.getByPhone(mobile);
        if (userEntity == null) {
            throw new UsernameNotFoundException("手机号未注册！");
        }
        return sysUserDetailsService.getUserDetails(userEntity);
    }
}
