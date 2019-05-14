package com.xiankejidaxue.yinjianping.bus.repository.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.BusInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:32 2019/5/14
 * @Modified By:
 */
@Repository
public interface BusInfoRepository extends JpaRepository<BusInfo,Integer> {

}
