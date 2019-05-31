package com.xiankejidaxue.yinjianping.bus.service;

import com.xiankejidaxue.yinjianping.bus.entity.Point;
import com.xiankejidaxue.yinjianping.bus.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:yinjianping
 * @Description:查询的point获取的经纬度直接入库，以后每次查询的时候先从数据库中读取。
 * @Date:Created in 22:53 2019/5/15
 * @Modified By:
 */
@Service
public class PointService {
    @Autowired
    private PointRepository pointRepository;

    /**
    * @Author:yinjianping
    * @Description:入库
    * @Date: 22:57 2019/5/15
    * @Params:
    * @Return :
    */
    public Point saveAPoint(Point point){
        return pointRepository.save(point);
    }

    /**
    * @Author:yinjianping
    * @Description:查询
    * @Date: 22:57 2019/5/15
    * @Params:
    * @Return :
    */
    public Point findByLocation(String location){
        return pointRepository.findByLocation(location).get();
    }
}
