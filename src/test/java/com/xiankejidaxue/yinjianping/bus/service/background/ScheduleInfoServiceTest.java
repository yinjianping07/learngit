package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import com.xiankejidaxue.yinjianping.bus.entity.background.ScheduleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 15:35 2019/5/28
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class ScheduleInfoServiceTest {

    @Autowired
    private ScheduleInfoService scheduleInfoService;

    @Test
    public void findAllScheduleInfo() {
    }

    @Test
    public void saveAScehduleInfo() {
        ScheduleInfo scheduleInfo = new ScheduleInfo();
        scheduleInfo.setTimeId(176);
        scheduleInfo.setDriverId(11);
        scheduleInfo.setLineId(115);
        scheduleInfo.setBusId(2);
        scheduleInfo.setState(0);

        scheduleInfoService.saveAScehduleInfo(scheduleInfo);
    }

    @Test
    public void findByTimeId(){
        System.out.println(scheduleInfoService.findByLineId(120));
    }
}