package top.flobby.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import top.flobby.common.enums.DeleteFlagEnum;
import top.flobby.security.user.SecurityUser;
import top.flobby.security.user.UserDetail;

import java.util.Date;

/**
 * @author : Flobby
 * @program : admin-template
 * @description : 自动填充
 * @create : 2023-04-20 19:16
 **/
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private final static String CREATOR = "creator";
    private final static String CREATE_TIME = "createTime";
    private final static String UPDATER = "updater";
    private final static String UPDATE_TIME = "updateTime";
    private final static String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        UserDetail user = SecurityUser.getUser();
        Date date = new Date();
        // 创建者
        strictInsertFill(metaObject, CREATOR, Long.class, user.getId());
        // 创建时间
        strictInsertFill(metaObject, CREATE_TIME, Date.class, date);
        // 更新者
        strictInsertFill(metaObject, UPDATER, Long.class, user.getId());
        // 更新时间
        strictInsertFill(metaObject, UPDATE_TIME, Date.class, date);
        // 删除标识
        strictInsertFill(metaObject, DELETED, Integer.class, DeleteFlagEnum.NOT_DELETED.getValue());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新者
        strictUpdateFill(metaObject, UPDATER, Long.class, SecurityUser.getUserId());
        // 更新时间
        strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
    }
}