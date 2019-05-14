package com.xiankejidaxue.yinjianping.bus.service;

import com.xiankejidaxue.yinjianping.bus.opencv.OpenCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 14:37 2019/5/12
 * @Modified By:
 */
@Service
public class OpenCVService {

    @Autowired
    private OpenCV openCV;


    public Integer getFaceNum(){
        return openCV.faceNum();
    }
}
