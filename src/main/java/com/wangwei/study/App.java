package com.wangwei.study;

import com.wangwei.study.dao.UserDao;
import com.wangwei.study.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(context.getBean(UserDao.class));
        System.out.println(context.getBean(User.class));
        System.out.println(context.getBean(Runnable.class));
        context.close();
    }
}
