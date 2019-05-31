package com.xiankejidaxue.yinjianping.bus.repository;

import com.xiankejidaxue.yinjianping.bus.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 16:38 2019/5/12
 * @Modified By:
 */
@Repository
public interface PointRepository extends JpaRepository<Point,Integer> {

    /**
    * @Author:yinjianping
    * @Description:根据出入的location查找一个point
    * @Date: 23:03 2019/5/15
    * @Params: String location
    * @Return :com.xiankejidaxue.yinjianping.bus.entity.Point
    */
    Optional<Point> findByLocation(String location);
}
