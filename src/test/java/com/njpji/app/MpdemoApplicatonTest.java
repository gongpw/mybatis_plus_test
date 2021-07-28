package com.njpji.app;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpji.app.entity.User;
import com.njpji.app.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MpdemoApplicatonTest {

    @Autowired
    private UserMapper usermapper;

    //查找所有
    @Test
    public void test01(){
        List<User> users = usermapper.selectList(null);
        System.out.println(users);
    }
    //增加
    @Test
    public void test02(){
        User user = new User("tom", 24, "1788888@qq.com");
        int i = usermapper.insert(user);
        System.out.println(i);
    }
    //修改
    @Test
    public void test03(){
        User user = new User();
        user.setId(1419898018640740354L);
        user.setName("jerry");
       // user.setCreateTime(new Date());
        int i = usermapper.updateById(user);
        System.out.println("update"+ i);
    }

    //测试乐观锁
    @Test
    public void test04(){
        User user = usermapper.selectById(1419934853211484161L);
        user.setName("Michael");

        int i = usermapper.updateById(user);
        System.out.println(i);
    }
    //分页
    @Test
    public void test05(){
        Page<User> page = new Page<>(1,3);
        usermapper.selectPage(page,null);
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getSize());//当前页数量
        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有下一页
    }
    //逻辑删除
    @Test
    public void test06(){
        int i = usermapper.deleteById(1419935634488651777L);
        System.out.println("已删除" + i);
    }

}
