package com.spring.study.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.study.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Qi
 * @version 1.0
 * @className UserMapper
 * @description TODO
 * @date 2022/1/10 16:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
