package com.hjj;

import com.hjj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: HJJ
 * @Date: 2019/04/30 09:07
 * @Description: Spring + 原生 JDBC
 */
@Component
public class JdbcTest {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(User u) {
        String sql = "insert into t_user " + "values(null, ?, ?)";//普通的sql语句
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setInt(2, u.getAge());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "META-INF/applicationContext.xml");
        JdbcTest t = (JdbcTest) ctx.getBean(JdbcTest.class);
        User u = new User();
        u.setName("dd");
        u.setAge(23333);
        t.insert(u);
    }
}
