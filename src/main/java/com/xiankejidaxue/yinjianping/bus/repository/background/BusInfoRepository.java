package com.xiankejidaxue.yinjianping.bus.repository.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.BusInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:32 2019/5/14
 * @Modified By:
 */
@Repository
public interface BusInfoRepository extends JpaRepository<BusInfo,Integer> {

    @Query(value = "select * from bus_info WHERE bus_brand LIKE ?1",
            nativeQuery = true)
    List<BusInfo> findLikeName(String name);

}
