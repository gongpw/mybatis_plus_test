package com.njpji.app.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandle implements MetaObjectHandler {

    @Override   //增加数据时 自动填充创造时间和修改时间
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

        this.setFieldValByName("version",1,metaObject);
    }

    @Override // 修改数据时 自动更新修改时间
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
