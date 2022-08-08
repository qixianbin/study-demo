package com.spring.study.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xianbin.Qi
 * @description TODO
 * @date 2022/8/5 15:13
 */
public interface IUserService {

    public User getUserById(int id);
    
    public Page<User> getUserByCondition();
    
    public void add() throws ClassNotFoundException;
    
}
