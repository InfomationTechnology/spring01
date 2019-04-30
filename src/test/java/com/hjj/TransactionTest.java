package com.hjj;

import com.hjj.service.AccountService;
import com.hjj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: HJJ
 * @Date: 2019/04/24 09:02
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/applicationContext.xml")
public class TransactionTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @Autowired HelloWorld he;

    @Test
    public void tranTest(){
        //遇到异常则回滚
        accountService.transfer(2,1,100d);
    }

    @Test
    public void test(){
//        HelloWorld he = new  HelloWorld();
//        he.setName("haha");
//        he.hello();
        userService.save();
    }
}
