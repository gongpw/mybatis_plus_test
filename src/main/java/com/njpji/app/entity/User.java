package com.njpji.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @TableId(type = IdType.ID_WORKER) //设置主键的生成策略
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //自动化填充所需注解
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//
    private Date updateTime;


    //加乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    //实现逻辑删除
    @TableLogic
    private Integer deleted;

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }


}
