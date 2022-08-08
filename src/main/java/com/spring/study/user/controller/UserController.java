package com.spring.study.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.study.user.entity.User;
import com.spring.study.user.service.IUserService;
import com.spring.study.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    
    //通过autowired注入，如果需要注入的接口有多个实现类，属性名需要跟一个实现类名字相同（属性名首字母小写）或者采用@Qualifier指定一个实现类的名字
    @Autowired
    IUserService userService;
    
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
