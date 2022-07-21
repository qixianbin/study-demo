package com.spring.study.user.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.service.UserService2;
import com.spring.study.user.dao.UserMapper;
import com.spring.study.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Qi
 * @version 1.0
 * @className UserService
 * @description TODO
 * @date 2022/1/10 16:45
 */
@Service("userService3")
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserService2 service2;
    
    @Autowired
    UserService service;
    
    public User getUserById(int id){
        return userMapper.selectById(id);
    }
    
    public Page<User> getUserByCondition(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",1);
    
        Page<User> userPage = userMapper.selectPage(new Page<User>(1, 2), wrapper);
    
        return userPage;
    
    }
    
    
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
