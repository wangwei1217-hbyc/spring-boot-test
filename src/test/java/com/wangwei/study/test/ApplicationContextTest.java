package com.wangwei.study.test;

import com.wangwei.study.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangwei on 2018/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestBeanConfiguration.class})
public class ApplicationContextTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testBean(){
        Assert.assertNotNull(context.getBean(User.class));
    }
    @Test
    public void testRunnable(){
        Assert.assertNotNull(context.getBean(Runnable.class));
    }
}
