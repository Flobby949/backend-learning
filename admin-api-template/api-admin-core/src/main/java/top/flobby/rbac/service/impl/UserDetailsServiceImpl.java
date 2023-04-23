package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.flobby.rbac.dao.SysUserDao;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.service.SysUserDetailsService;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 我们的账号密码是存储在数据库里面的，SpringSecurity为我们提供了UserDetailsService接口，只需要实现 UserDetailsService接口
 * @create : 2023-04-23 18:48
 **/

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity userEntity = sysUserDao.getByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        return sysUserDetailsService.getUserDetails(userEntity);
    }

}