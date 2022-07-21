package com.spring.study.user.service;


import com.spring.study.user.dao.UserMapper;
import com.spring.study.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService2 {
    
    @Resource
    UserMapper dao;
    
    @Transactional
    public void add2() throws ClassNotFoundException {
        User u = new User();
        u.setUserName("李四");
        u.setAge(13);
     
     
        Class.forName("asfsdf");
        dao.insert(u);
        
//        throw new RuntimeException("123");
        //此类型的异常不会回滚
//        throw new SQLException();
    }
}
