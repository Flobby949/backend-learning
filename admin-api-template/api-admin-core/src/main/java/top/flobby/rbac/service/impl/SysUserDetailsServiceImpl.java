package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.flobby.rbac.convert.SysUserConvert;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.enums.UserStatusEnum;
import top.flobby.rbac.service.SysUserDetailsService;
import top.flobby.security.user.UserDetail;

import java.util.HashSet;
import java.util.Set;


/**
 * 获取用户 UserDetails 信息服务
 *
 * @author flobby
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {

    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        // 用户权限列表
        Set<String> authoritySet = new HashSet<>();
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }
}
