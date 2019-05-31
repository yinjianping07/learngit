package com.xiankejidaxue.yinjianping.bus.service;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 10:43 2019/5/27
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAUser() {
    }

    @Test
    public void insertAUser() {
    }

    @Test
    public void findAllUsers() {
    }

    @Test
    public void findAName() {
    }

    @Test
    public void findThisStatus() {
        System.out.println(userService.findThisStatus("gaozhan"));
    }

    @Test
    public void findThisPassword() {
    }
}