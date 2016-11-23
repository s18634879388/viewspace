package com.view.dao;

import com.view.domain.UserTest;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */
@Repository
public class ViewDao {
    @Autowired
    @Qualifier("SqlSessionTemplate")
    SqlSessionTemplate sqlSessionTemplate;
    public void insertUser(UserTest userTest){
        sqlSessionTemplate.insert("addUser",userTest);
    }
    public List<UserTest> selectAllUser(){
        return sqlSessionTemplate.selectList("getAllUser");
    }
}
