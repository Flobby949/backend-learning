package top.flobby.rbac.service;


import org.springframework.web.multipart.MultipartFile;
import top.flobby.common.utils.PageResult;
import top.flobby.mybatis.service.BaseService;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.query.SysUserQuery;
import top.flobby.rbac.vo.SysUserVO;

import java.util.List;

/**
 * 用户管理
 *
 * @author flobby
 */
public interface SysUserService extends BaseService<SysUserEntity> {
    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 分页查询
     *
     * @param query 查询
     * @return {@link PageResult}<{@link SysUserVO}>
     */
    PageResult<SysUserVO> page(SysUserQuery query);

    /**
     * 新增
     *
     * @param vo vo
     */
    void save(SysUserVO vo);

    /**
     * 更新
     *
     * @param vo vo
     */
    void update(SysUserVO vo);

    /**
     * 删除
     *
     * @param ids ids
     */
    void delete(List<Long> ids);

    /**
     * 通过excel导入
     *
     * @param file     文件
     * @param password 密码
     */
    void importByExcel(MultipartFile file, String password);

    /**
     * 导出
     */
    void export();

    /**
     * 更新状态
     *
     * @param id     id
     * @param status 状态
     */
    void updateStatus(Long id, Integer status);

    /**
     * 通过手机获取用户
     *
     * @param mobile 手机号
     * @return {@link SysUserEntity}
     */
    SysUserEntity getByMobile(String mobile);
}
