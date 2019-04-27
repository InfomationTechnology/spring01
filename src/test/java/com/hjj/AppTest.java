package com.hjj;

import static org.junit.Assert.assertTrue;

import com.hjj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
//创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定容器使用配置文件
@ContextConfiguration("classpath:META-INF/applicationContext.xml")
public class AppTest 
{

    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        System.out.println(userService);
        userService.save();
    }
}
