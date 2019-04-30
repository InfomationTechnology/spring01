package com.hjj.service.impl;

import com.hjj.dao.jdbcTemplate.AccountDao;
import com.hjj.service.AccountService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 16:59
 * @Description:xml配置方式
 */

public class AccountServiceImpl implements AccountService {

    //注意此名字要与xml中的名字一致，否则无法注入
    private AccountDao accountDao;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
//    @Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
    public void transfer(Integer from, Integer to, Double money) {
        accountDao.decreaseMoney(from, money);
        int a = 1/0;  //加事务后遇到异常会回滚
        accountDao.increaseMoney(to, money);

        /*Map<String,Object> map = new HashMap<>();
        map.put("money","100");
        map.put("id","1");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("money","100");
        map2.put("id","2");
        sqlSessionTemplate.update("com.hjj.dao.mybatis.AccountMapper.decreaseMoney",map);
        int a = 1/0;
        sqlSessionTemplate.update("com.hjj.dao.mybatis.AccountMapper.increaseMoney",map2);*/
    }

    //set方法注入,
    public void setAccountDao(AccountDao aDao) {
        this.accountDao = aDao;
    }
}