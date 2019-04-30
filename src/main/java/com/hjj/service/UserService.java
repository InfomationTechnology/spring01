package com.hjj.service;

import com.hjj.model.User;

/**
 * @Auther: HJJ
 * @Date: 2019/04/22 16:39
 * @Description:
 */
public interface UserService {
    public void save();
    public void delete();
    public void update();
    public User find(int id);
}
