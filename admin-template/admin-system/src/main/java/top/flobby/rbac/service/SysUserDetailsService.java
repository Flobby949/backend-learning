package top.flobby.rbac.service;


import org.springframework.security.core.userdetails.UserDetails;
import top.flobby.rbac.entity.SysUserEntity;

/**
 * 用户信息服务
 * @author flobby
 */
public interface SysUserDetailsService {

    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
