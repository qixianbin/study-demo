package com.spring.study.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Qi
 * @version 1.0
 * @className User
 * @description TODO
 * @date 2022/1/10 16:53
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField("username")
    private String username;
}
