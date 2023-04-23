package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.dao.SysLogLoginDao;
import top.flobby.rbac.entity.SysLogLoginEntity;
import top.flobby.rbac.service.SysLogLoginService;

/**
 * @author : Flobby
 * @program : admin-template
 * @description :
 * @create : 2023-04-23 13:48
 **/

@Service
@AllArgsConstructor
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

}
