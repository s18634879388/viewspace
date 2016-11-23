package com.view.service;

import com.view.dao.ViewDao;
import com.view.domain.UserTest;
import com.view.mapper.UserTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/23.
 */
@Service
@Transactional
public class ViewService {
    @Autowired
    ViewDao viewDao;
//    @Autowired
//    UserTestMapper userTestMapper;
    //事务测试
    public void test(){
        UserTest userTest = new UserTest();
        userTest.setUserName("hameimei");
        userTest.setPassword("123456");
        userTest.setLastIp("127.0.0.1");
        userTest.setLastVisit(new Date());
//        userTestMapper.addUser(userTest);
        viewDao.insertUser(userTest);
//        throw new RuntimeException("test");
    }

}
