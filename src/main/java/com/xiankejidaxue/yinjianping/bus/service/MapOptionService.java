package com.xiankejidaxue.yinjianping.bus.service;

import com.xiankejidaxue.yinjianping.bus.entity.Point;
import com.xiankejidaxue.yinjianping.bus.exception.PathFoundFailException;
import com.xiankejidaxue.yinjianping.bus.mapBase.MapOption;
import com.xiankejidaxue.yinjianping.bus.mapBase.MapResult;
import com.xiankejidaxue.yinjianping.bus.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 10:52 2019/5/21
 * @Modified By:
 */
@Service
public class MapOptionService {
    @Autowired
    private MapOption mapOption;

    @Autowired
    private PointRepository pointRepository;

    public Integer getBetweenService(Point origin,Point destination)throws PathFoundFailException{
        List<MapResult> paths = mapOption.getBetween(origin,destination);
        if (paths.isEmpty()){
            throw new PathFoundFailException("获取驾驶信息失败");
        }
        else{
            return paths.get(0).getDuration();
        }
    }

    public Point getPointService(String string){
        Point point = pointRepository.findByLocation(string).get();
        if (point.equals(null)){
            return mapOption.getPoint(string);
        }else {
            return point;
        }
    }
}
