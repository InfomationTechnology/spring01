package com.hjj.dao;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 16:57
 * @Description:
 */
public interface AccountDao {
    //加钱
    void increaseMoney(Integer id, Double money);
    //减钱
    void decreaseMoney(Integer id,Double money);
}
