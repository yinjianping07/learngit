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
 * @Date:Created in 22:53 2019/5/12
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class OpenCVServiceTest {

    @Autowired
    private OpenCVService openCVService;

    @Test
    public void getFaceNum() {
        System.out.println(openCVService.getFaceNum());
    }
}