package com.wangwei.study.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 测试时，springboot会优先加载测试环境下的配置文件（application.properties）
 *  测试环境下没有，才会去正式环境下加载配置文件。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app.version=1.0"})
public class EnvTest {
    @Resource
    private ConfigurableEnvironment environment;

    @Before
    public void init(){
        EnvironmentTestUtils.addEnvironment(environment,"app.admin.name=admin","app.admin.enable=true");
    }

    @Test
    public void testEnv(){
        Assert.assertEquals("springboottest", environment.getProperty("app.name"));
        Assert.assertEquals("1.0", environment.getProperty("app.version"));
        Assert.assertEquals("admin", environment.getProperty("app.admin.name"));
        Assert.assertEquals("true", environment.getProperty("app.admin.enable"));
    }
}
