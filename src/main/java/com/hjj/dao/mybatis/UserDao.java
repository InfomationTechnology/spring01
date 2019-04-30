package com.hjj.dao.mybatis;

import com.hjj.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Auther: HJJ
 * @Date: 2019/04/28 17:27
 * @Description: mybatis crud
 */
@Repository(value = "userDao1")
public class UserDao extends SqlSessionDaoSupport {


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public User getById(int id) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        return this.getSqlSession().selectOne(this.getClass().getName() + ".getById", id);
    }
//使用SqlSessionDaoSupport必须注意，此处源码1.1.1中有自动注入，1.2中取消了自动注入，需要手工注入，侵入性强
        //也可在spring-mybatis.xml中如下配置，但是这种有多少个dao就要配置到少个，多个dao就很麻烦。
        //<bean id="userDao" class="com.hua.saf.dao.UserDao">
        //    <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
        //</bean>
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        // TODO Auto-generated method stub
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
