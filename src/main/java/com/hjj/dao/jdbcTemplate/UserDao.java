package com.hjj.dao.jdbcTemplate;

import com.hjj.model.User;

import java.util.List;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 15:24
 * @Description:
 */
public interface UserDao {
    public void save(User user);
    public void delete(Integer id);
    public void update(User user);
    public User getById(Integer id);
    public int getTotalCount();
    public List<User> getAll();
}
