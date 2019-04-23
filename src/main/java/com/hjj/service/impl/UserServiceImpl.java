package com.hjj.service.impl;

import com.hjj.service.UserService;

/**
 * @Auther: HJJ
 * @Date: 2019/04/22 16:40
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存");
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
    public void find() {
        System.out.println("查找");
    }
}
