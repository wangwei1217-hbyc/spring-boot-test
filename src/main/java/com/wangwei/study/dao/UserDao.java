package com.wangwei.study.dao;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Created by wangwei on 2018/4/7.
 */
@Repository
public class UserDao {

    public Integer addUser(String name){
        System.out.println("userDao addUser: username=["+name+"]");
        if(StringUtils.isEmpty(name)){
            return 0;
        }
        return 1;
    }
}
