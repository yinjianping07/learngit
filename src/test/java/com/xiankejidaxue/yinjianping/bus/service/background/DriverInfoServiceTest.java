package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import com.xiankejidaxue.yinjianping.bus.entity.background.DriverInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 19:50 2019/5/27
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class DriverInfoServiceTest {

    @Autowired
    private DriverInfoService driverInfoService;

    @Test
    public void findAllDriverInfo() {
    }

    @Test
    public void saveADriver() {

        String [] names = {"李四","王五","尹建平","王易成","杨佩恒","马宇豪","白杰","刘敬"};

        for(int i = 0;i<50;i++) {
            DriverInfo driverInfo = new DriverInfo();
            driverInfo.setDriverName(names[50%8]);
            driverInfo.setDriverAge(30+(50%8));
            driverInfo.setDriverSex("男");
            driverInfo.setDriverTelphone("18392601389");
            driverInfo.setDriverLandLine("029-156328");
            driverInfo.setDriverLocation("陕西省西安市临潼区西安科技大学");
            driverInfo.setDriverNumber("123456789");
            driverInfo.setDriverLimit(10);
            driverInfo.setDriverEmploy(0);
            driverInfo.setDriverComment("trationDelegate$BeanPostProcessorChecker : Bean 'userInfoRepository' of type [org.springframework.data");
            driverInfo.setDriverInUse(0);

            driverInfoService.saveADriver(driverInfo);
        }
    }

    @Test
    public void findNameLike(){
        String name = "六";
        System.out.println(driverInfoService.findNameLike(name));
    }
}