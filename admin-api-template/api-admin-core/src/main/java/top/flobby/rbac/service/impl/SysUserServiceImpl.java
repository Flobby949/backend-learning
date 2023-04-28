package top.flobby.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.flobby.common.excel.ExcelFinishCallBack;
import top.flobby.common.exception.ServerException;
import top.flobby.common.utils.ExcelUtils;
import top.flobby.common.utils.PageResult;
import top.flobby.mybatis.service.impl.BaseServiceImpl;
import top.flobby.rbac.convert.SysUserConvert;
import top.flobby.rbac.dao.SysUserDao;
import top.flobby.rbac.entity.SysUserEntity;
import top.flobby.rbac.enums.SuperAdminEnum;
import top.flobby.rbac.query.SysUserQuery;
import top.flobby.rbac.service.SysUserService;
import top.flobby.rbac.vo.SysUserExcelVO;
import top.flobby.rbac.vo.SysUserVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static top.flobby.common.constant.Constant.DEFAULT_PASSWORD;
import static top.flobby.common.constant.Constant.ENABLE;

/**
 * 系统用户服务
 *
 * @author flobby
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        // 查询条件
        Map<String, Object> params = new HashMap<>(3);
        params.put("username", query.getUsername());
        params.put("mobile", query.getMobile());
        params.put("gender", query.getGender());
        // 分页
        IPage<SysUserEntity> page = getPage(query);
        List<SysUserEntity> userEntityList = baseMapper.getList(params);
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(userEntityList), page.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) {
        // 判断手机号和用户名是否重复
        if (baseMapper.getByUsername(vo.getUsername()) != null || baseMapper.getByPhone(vo.getMobile()) != null) {
            throw new ServerException("用户名或手机号已存在");
        }
        // 构造参数
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        if (entity.getStatus() == null) {
            entity.setStatus(ENABLE);
        }
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserVO vo) {
        // 判断手机号和用户名是否重复
        SysUserEntity byUsername = baseMapper.getByUsername(vo.getUsername());
        if (byUsername != null && !byUsername.getId().equals(vo.getId())) {
            throw new ServerException("用户名已存在");
        }
        SysUserEntity byPhone = baseMapper.getByPhone(vo.getMobile());
        if (byPhone != null && !byPhone.getId().equals(vo.getId())) {
            throw new ServerException("手机号已存在");
        }
        // 更改
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importByExcel(MultipartFile file, String password) {
        ExcelUtils.readAnalysis(file, SysUserExcelVO.class, new ExcelFinishCallBack<>() {
            @Override
            public void doAfterAllAnalysed(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            @Override
            public void doSaveBatch(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            private void saveUser(List<SysUserExcelVO> result) {
                // 枚举转换
                // ExcelUtils.parseDict(result);
                // 数据转换为
                List<SysUserEntity> sysUserEntities = SysUserConvert.INSTANCE.convertListEntity(result);
                // 设置初始密码
                sysUserEntities.forEach(user -> user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD)));
                // TODO 账号唯一性校验
                saveBatch(sysUserEntities);
            }
        });
    }

    @Override
    @SneakyThrows
    public void export() {
        List<SysUserEntity> list = list(Wrappers.lambdaQuery(SysUserEntity.class).eq(SysUserEntity::getSuperAdmin, SuperAdminEnum.NO.getName()));
        List<SysUserExcelVO> userExcelVOList = SysUserConvert.INSTANCE.covert2List(list);
        // 导出到下载
        ExcelUtils.excelExport(SysUserExcelVO.class, "用户数据", "sheet1", userExcelVOList);
    }

}
