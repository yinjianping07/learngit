package com.xiankejidaxue.yinjianping.bus.repository.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.LineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:52 2019/5/14
 * @Modified By:
 */
@Repository
public interface LineInfoRepository extends JpaRepository<LineInfo,Integer>{

    /**
    * @Author:yinjianping
    * @Description:根据站点查找
    * @Date: 12:58 2019/5/28
    * @Params:
    * @Return :
    */
    List<LineInfo> findByLineSiteLike(String site);
}
