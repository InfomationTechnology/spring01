package com.hjj.service.impl;


import com.hjj.dao.mybatis.UserDao;
import com.hjj.model.User;
import com.hjj.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: HJJ
 * @Date: 2019/04/22 16:40
 * @Description: 注解方式
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        logger.info("保存");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public User find(int id) {
        logger.info("查找");
        return userDao.getById(id);
    }
}
