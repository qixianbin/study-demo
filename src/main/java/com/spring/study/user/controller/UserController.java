package com.spring.study.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.entity.User;
import com.spring.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

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
     * @param
     * @return java.lang.String
     */
    @RequestMapping(value = "/user/{id}" )
    public String getUserById(@PathVariable(name="id") int id){
        User user = userService.getUserById(id);
        return user.toString();
    }
    
    /**
     * @describe TODO
     * @date 2022/1/10 18:27
     * @author xianbin.Qi
     * @return java.lang.String
     */
    @RequestMapping(value = "/user/page" )
    public Page<User> getUserByPage(){
        Page<User> userPage = userService.getUserByCondition();
        return userPage;
    }
    
    @RequestMapping("/addUser")
    public void add() throws ClassNotFoundException {
        userService.add();
    }
}
