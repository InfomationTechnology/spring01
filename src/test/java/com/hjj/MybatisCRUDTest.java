package com.hjj;

import com.hjj.dao.jdbcTemplate.AccountDao;
import com.hjj.dao.mybatis.AccountMapper;
import com.hjj.dao.mybatis.UserDao;
import com.hjj.model.User;
import com.hjj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/applicationContext.xml")
public class MybatisCRUDTest
{

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    private AccountMapper accountMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Test
    public void save()
    {
    }

    @Test
    public void update() {
        Map<String,Object> map = new HashMap<>();
        map.put("money","100");
        map.put("id","1");
        //decreaseMoney 减钱  increaseMoney  加钱
//        sqlSessionTemplate.update("com.hjj.dao.mybatis.AccountMapper.decreaseMoney",map);
        sqlSessionTemplate.update("com.hjj.dao.mybatis.AccountMapper.increaseMoney",map);
    }

    @Test
    public void update2() {
        accountMapper.increaseMoney(2,100d);
    }

    @Test
    public void findById()
    {
        User u = userService.find(3);
        System.out.println(u);
    }

    @Test
    public void findByAll()
    {
    }

    @Test
    public void count()
    {
    }

    @Test
    public void delete()
    {
    }
}
