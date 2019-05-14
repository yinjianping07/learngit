package com.xiankejidaxue.yinjianping.bus.controller.wxController;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 14:40 2019/5/14
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class wxLoginTest {

    private MockMvc mockMvc;

    @Test
    public void wxLogin() {
        System.out.println("test");
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/test")
//        .a)
    }
}