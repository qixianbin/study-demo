package com.spring.study.user.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.dao.UserMapper;
import com.spring.study.user.entity.User;
import com.spring.study.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService2")
public class UserServiceImpl2 implements IUserService {
    
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
    
    @Override
    public User getUserById(int id) {
        return null;
    }
    
    @Override
    public Page<User> getUserByCondition() {
        return null;
    }
    
    @Override
    public void add() throws ClassNotFoundException {
    
    }
}
