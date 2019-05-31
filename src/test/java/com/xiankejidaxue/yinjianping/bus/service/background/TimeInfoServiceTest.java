package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import com.xiankejidaxue.yinjianping.bus.entity.background.TimeInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 15:27 2019/5/28
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class TimeInfoServiceTest {

    @Autowired
    private TimeInfoService timeInfoService;

    @Test
    public void findAllTime() {
    }

    @Test
    public void saveATime() {

        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setTimePoint("21:00");
        timeInfoService.saveATime(timeInfo);
    }
}