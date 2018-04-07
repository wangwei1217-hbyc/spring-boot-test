package com.wangwei.study.test;

import com.wangwei.study.controller.UserController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 *   @WebMvcTest 不需要运行在Web环境中，但需要指定参数controllers，指明需要测试哪些Controller。
 *      --只测试Controller，controller中的一些依赖，需要自己去mock。
 *   @WebMvcTest 不会加载整个Spring容器。
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UserController.class})
public class UserControllerTest2 {

    @Resource
    private MockMvc mockMvc;
    @Test
    public void testHome() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("home"));
    }

    @Test
    public void testShow() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/show").param("id","420984"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("show-420984"));
    }
    @Test
    public void testList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/list/9420"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("list-9420"));
    }
}
