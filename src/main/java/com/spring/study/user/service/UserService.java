package com.spring.study.user.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.dao.UserMapper;
import com.spring.study.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qi
 * @version 1.0
 * @className UserService
 * @description TODO
 * @date 2022/1/10 16:45
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    public User getUserById(int id){
        return userMapper.selectById(id);
    }
    
    public Page<User> getUserByCondition(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",1);
    
        Page<User> userPage = userMapper.selectPage(new Page<User>(1, 2), wrapper);
    
        return userPage;
    
    }
}
