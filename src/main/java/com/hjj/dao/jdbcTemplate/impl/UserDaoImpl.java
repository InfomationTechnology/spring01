package com.hjj.dao.jdbcTemplate.impl;

import com.hjj.dao.jdbcTemplate.UserDao;
import com.hjj.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: HJJ
 * @Date: 2019/04/23 15:25
 * @Description: JdbcTemplate  注解方式
 */
//使用JDBC模板实现增删改查
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    //xml方式要给jdbcTemplate设置setter方法
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(User u) {
        String sql="insert into t_user values(null,?,?)";
        getJdbcTemplate().update(sql, u.getName(),u.getAge());

        logger.info("保存成功");
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from t_user where id=?";
        getJdbcTemplate().update(sql, id);
        System.out.println("删除成功");
    }

    @Override
    public void update(User u) {
        String sql="update t_user set name=? where id=?";
        getJdbcTemplate().update(sql, u.getName(),u.getId());
        System.out.println("修改成功");
    }

    @Override
    public User getById(Integer id) {
        String sql="select * from t_user where id=?";
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

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
        Integer count = getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql="select * from t_user";
        return getJdbcTemplate().query(sql,new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }});
    }



    private JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/
}
