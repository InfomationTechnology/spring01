package com.hjj.dao.mybatis;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 16:57
 * @Description:
 */
public interface AccountMapper {
    //加钱
    public void increaseMoney(@Param("id") Integer id, @Param("money") Double money);
    //减钱
    public void decreaseMoney(@Param("id") Integer id, @Param("money") Double money);
}
