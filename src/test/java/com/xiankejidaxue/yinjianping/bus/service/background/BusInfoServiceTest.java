package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import com.xiankejidaxue.yinjianping.bus.entity.background.BusInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 14:57 2019/5/27
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class BusInfoServiceTest {

    @Autowired
    private BusInfoService busInfoService;

    @Test
    public void findABusInfoById() {
        BusInfo busInfo = busInfoService.findABusInfo(10);
        assertEquals(busInfo.getBusBrand(),"宇通客车");
    }

    @Test
    public void findAllBusInfo() {
    }

    @Test
    public void saveBusInfo() {
        BusInfo busInfo = new BusInfo();

        for (int i = 1;i<50;i++) {
            busInfo.setBusSiteNumber(100-i);
            busInfo.setBusBrand("宇通客车");
            busInfo.setBusLicense("陕A 123"+String.valueOf((int)(Math.random()*100)));
            busInfo.setBusYear(60);
            busInfo.setBusLease(0);
            busInfo.setBusInUse(0);
            busInfo.setBusInsuranceCompany("西安科技大学");
            busInfo.setBusInsuranceLife(60);

            busInfoService.saveBusInfo(busInfo);
        }
    }

    @Test
    public void findNameLike(){
        String name = "通";
        System.out.println(busInfoService.findNameLike(name));
    }
}