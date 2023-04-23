package top.flobby.rbac.service;

import top.flobby.common.utils.PageResult;
import top.flobby.mybatis.service.BaseService;
import top.flobby.rbac.entity.SysLogLoginEntity;
import top.flobby.rbac.query.SysLogLoginQuery;
import top.flobby.rbac.vo.SysLogLoginVO;

/**
 * @author : JinChenXing
 * @program : admin-template
 * @description :
 * @create : 2023-04-23 13:48
 **/

public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {
    /**
     * 按条件分页查询
     *
     * @param query 查询参数
     * @return {@link PageResult}<{@link SysLogLoginVO}>
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     *
     * @param username  用户名
     * @param status    状态
     * @param operation 操作
     */
    void save(String username, Integer status, Integer operation);
}
