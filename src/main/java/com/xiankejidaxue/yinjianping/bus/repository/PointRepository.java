package com.xiankejidaxue.yinjianping.bus.repository;

import com.xiankejidaxue.yinjianping.bus.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 16:38 2019/5/12
 * @Modified By:
 */
@Repository
public interface PointRepository extends JpaRepository<Point,Integer> {
}
