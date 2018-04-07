package com.wangwei.study.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *   TestRestTemplate需要运行在Web环境中
 *   @SpringBootTest 会加载整个Spring容器
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Resource
    private TestRestTemplate restTemplate;
    @Test
    public void testHome(){
        String content = restTemplate.getForObject("/home", String.class);
        Assert.assertEquals("home",content);
    }

    @Test
    public void testShow(){
        String content = restTemplate.getForObject("/show?id=520", String.class);
        Assert.assertEquals("show-520",content);
    }
    @Test
    public void testList(){
        String content = restTemplate.getForObject("/list/1217", String.class);
        Assert.assertEquals("list-1217",content);
    }
}
