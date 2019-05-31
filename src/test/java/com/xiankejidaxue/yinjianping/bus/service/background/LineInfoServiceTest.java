package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.BusApplication;
import com.xiankejidaxue.yinjianping.bus.entity.background.LineInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 15:14 2019/5/28
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class LineInfoServiceTest {

    @Autowired
    private LineInfoService lineInfoService;

    @Test
    public void findAllLineInfos() {
    }

    @Test
    public void findLineLike() {
    }

    @Test
    public void saveALine() {
        for (int i = 0; i < 50; i++) {

            LineInfo lineInfo = new LineInfo();
            lineInfo.setLineSign(0);
            lineInfo.setLineSiteNumber(8);
            lineInfo.setLineSite("成都,西安,北京,杭州,上海,广州,深圳,西安科技大学临潼校区");
            lineInfo.setLineTime(50);
            lineInfo.setLineMileage(25256);

            lineInfoService.saveALine(lineInfo);
        }
    }
}