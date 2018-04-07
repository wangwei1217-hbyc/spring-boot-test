package com.wangwei.study.controller;

import com.wangwei.study.dao.UserDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wangwei on 2018/4/7.
 */
@RestController
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping(value = "/home")
    public String home(){
        System.out.println("----home");
        userDao.addUser("huying");
        return "home";
    }

    @RequestMapping(value = "/show")
    public String show(@RequestParam("id") Integer id){
        System.out.println("----show--"+id);
        userDao.addUser("huying");
        return "show-"+id;
    }

    @RequestMapping(value = "/list/{id}")
    public String list(@PathVariable("id") Integer id){
        System.out.println("----list--"+id);
        userDao.addUser("huying");
        return "list-"+id;
    }
}
