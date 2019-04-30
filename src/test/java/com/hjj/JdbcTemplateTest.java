package com.hjj;

import com.hjj.dao.jdbcTemplate.UserDao;
import com.hjj.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/applicationContext.xml")
public class JdbcTemplateTest
{

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDao userDaoSupport;

    @Test
    public void save()
    {
        User u= new User();
        u.setName("老王"+new Random().nextInt(100));
        u.setAge(25);
        userDao.save(u);
    }

    @Test
    public void update()
    {
        User u=new User();
        u.setId(2);
        u.setName("YYY");

        userDao.update(u);;
    }

    @Test
    public void findById()
    {
        User u1 = userDaoSupport.getById(3);
        User u2 = userDao.getById(3);
        System.out.println(u1);
        System.out.println(u2);
    }

    @Test
    public void findByAll()
    {
        List<User> userList = userDao.getAll();
        userList.forEach(u-> {System.out.println(u);});
    }

    @Test
    public void count()
    {
        System.out.println(userDao.getTotalCount());
    }

    @Test
    public void delete()
    {
        userDao.delete(2);
    }
}
