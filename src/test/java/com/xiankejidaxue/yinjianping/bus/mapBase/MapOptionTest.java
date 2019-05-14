package com.xiankejidaxue.yinjianping.bus.mapBase;

import com.xiankejidaxue.yinjianping.bus.entity.Point;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 20:47 2019/5/12
 * @Modified By:
 */
public class MapOptionTest {

    @Test
    public void getBetween() {
        MapOption mapOption = new MapOption();
        Point point1 = mapOption.getPoint("陕西省西安临潼区西安科技大学");
        Point point2 = mapOption.getPoint("陕西省西安市新城区五路口");

        String time = "";
        int second = mapOption.getBetween(point1, point2).get(0).getDuration();
        time = mapOption.timeTransfer(second);
        System.out.println("从"+point1.getLocation()+"到"+point2.getLocation()+"需要的时间大约："+time);
    }

    @Test
    public void getPoint() {
        MapOption mapOption = new MapOption();
        System.out.println(mapOption.getPoint("西安科技大学临潼校区"));
    }

    @Test
    public void timeTransfer() {
        MapOption mapOption = new MapOption();
        System.out.println(mapOption.timeTransfer(59));
    }
}