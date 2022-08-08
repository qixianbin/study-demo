package com.spring.study.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.dao.UserMapper;
import com.spring.study.user.entity.User;
import com.spring.study.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Qi
 * @version 1.0
 * @className UserService
 * @description TODO
 * @date 2022/1/10 16:45
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    UserServiceImpl2 service2;
    
    @Autowired
    UserServiceImpl service;
    
    @Override
    public User getUserById(int id){
        log.info("id = " + id);
        return userMapper.selectById(id);
    }
    
    @Override
    public Page<User> getUserByCondition(){
        log.info("====");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",1);
    
        Page<User> userPage = userMapper.selectPage(new Page<User>(1, 2), wrapper);
    
        return userPage;
    
    }
    
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add() throws ClassNotFoundException {
        User u = new User();
        u.setUserName("张三");
        u.setAge(13);
        userMapper.insert(u);
        //        service.add2();
        service2.add2();
        //        throw new RuntimeException("123");
    }
    
    //    @Transactional
    private void add2(){
        User u = new User();
        u.setUserName("李四");
        u.setAge(13);
        userMapper.insert(u);
        throw new RuntimeException("123");
    }
}
