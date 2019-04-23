package com.hjj.service.impl;

import com.hjj.dao.AccountDao;
import com.hjj.service.AccountService;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 16:59
 * @Description:
 */
public class AccountServiceImpl implements AccountService {

    //注意此名字要与xml中的名字一致，否则无法注入
    private AccountDao accountDao;
    @Override
    public void transfer(Integer from, Integer to, Double money) {
        // TODO Auto-generated method stub
        accountDao.decreaseMoney(from, money);
        accountDao.increaseMoney(to, money);
    }

    //set方法注入,
    public void setAccountDao(AccountDao aDao) {
        this.accountDao = aDao;
    }
}