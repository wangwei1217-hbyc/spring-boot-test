package com.wangwei.study.test;

import com.wangwei.study.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 针对接口，使用@MockBean注解进行测试.
 */
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @MockBean
    private UserMapper userMapper;

    /**
     * 现进行预测。使用BDDMockito类
     */
    @Before
    public void init(){
        BDDMockito.given(userMapper.createUser("admin")).willReturn(1);
        BDDMockito.given(userMapper.createUser("")).willReturn(0);
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);

    }

    @Test(expected = NullPointerException.class)
    public void testCreateUser(){
        Assert.assertEquals(Integer.valueOf(1),userMapper.createUser("admin"));
        Assert.assertEquals(Integer.valueOf(0),userMapper.createUser(""));
        Assert.assertEquals(Integer.valueOf(0),userMapper.createUser(null));

    }
}
