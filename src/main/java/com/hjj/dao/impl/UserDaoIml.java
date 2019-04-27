package com.hjj.dao.impl;

import com.hjj.dao.UserDao;
import com.hjj.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 15:25
 * @Description:
 */
//使用JDBC模板实现增删改查
public class UserDaoIml  extends JdbcDaoSupport implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoIml.class);

    //并且给jTemplate设置setter方法
//    private JdbcTemplate jTemplate;

    @Override
    public void save(User u) {
        String sql="insert into t_user values(null,?,?)";
        super.getJdbcTemplate().update(sql, u.getName(),u.getAge());
        logger.info("保存成功");
//        System.out.println("保存成功");
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from t_user where id=?";
        super.getJdbcTemplate().update(sql, id);
        System.out.println("删除成功");
    }

    @Override
    public void update(User u) {
        String sql="update t_user set name=? where id=?";
        super.getJdbcTemplate().update(sql, u.getName(),u.getId());
        System.out.println("修改成功");
    }

    @Override
    public User getById(Integer id) {
        String sql="select * from t_user where id=?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }}, id);
    }

    @Override
    public int getTotalCount() {
        String sql="select count(*) from t_user";
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql="select * from t_user";
        return super.getJdbcTemplate().query(sql,new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }});
    }

    /*public void setjTemplate(JdbcTemplate jTemplate) {
        this.jTemplate = jTemplate;
    }*/
}
