package com.wangwei.study.test;

import com.wangwei.study.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by wangwei on 2018/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testAddUser(){
        Assert.assertEquals(Integer.valueOf(0),userDao.addUser(null));
        Assert.assertEquals(Integer.valueOf(1),userDao.addUser("wangwei"));
    }
}
