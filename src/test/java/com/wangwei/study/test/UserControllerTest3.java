package com.wangwei.study.test;

import com.wangwei.study.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 *   @SpringBootTest 不能和 @WebMvcTest 同时使用
 *   如果需要使用MockMvc对象的话，需要加上@AutoConfigureMockMvc注解
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest3 {

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
