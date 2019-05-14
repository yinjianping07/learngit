package com.xiankejidaxue.yinjianping.bus.opencv;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 22:56 2019/5/12
 * @Modified By:
 */
public class OpenCVTest {

    @Test
    public void faceNum() {
        OpenCV openCV = new OpenCV();
        System.out.println(openCV.faceNum());
    }
}