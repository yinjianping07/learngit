package com.xiankejidaxue.yinjianping.bus.repository.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.DriverInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:51 2019/5/14
 * @Modified By:
 */
@Repository
public interface DriverInfoRepository extends JpaRepository<DriverInfo,Integer> {
}
