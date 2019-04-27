package com.hjj.dao.impl;

import com.hjj.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 16:58
 * @Description:
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void increaseMoney(Integer id, Double money) {
        super.getJdbcTemplate().update("update t_account set money =money+? where id=?",money,id);
        System.out.println("加钱成功");
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {
        // TODO Auto-generated method stub
        super.getJdbcTemplate().update("update t_account set money =money-? where id=?",money,id);
        System.out.println("减钱成功");
    }

}
