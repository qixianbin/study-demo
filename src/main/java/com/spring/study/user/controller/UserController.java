package com.spring.study.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.entity.User;
import com.spring.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qi
 * @description TODO
 * @date 2022/1/10 16:41
 */
@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    /**
     * @describe TODO
     * @date 2022/1/10 18:27
     * @author xianbin.Qi
     * @param [id]
     * @return java.lang.String
     */
    @RequestMapping(value = "/user/{id}" )
    public String getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        return user.toString();
    }
    
    /**
     * @describe TODO
     * @date 2022/1/10 18:27
     * @author xianbin.Qi
     * @param [id]
     * @return java.lang.String
     */
    @RequestMapping(value = "/user/page" )
    public Page<User> getUserByPage(){
        Page<User> userPage = userService.getUserByCondition();
        return userPage;
    }
}
