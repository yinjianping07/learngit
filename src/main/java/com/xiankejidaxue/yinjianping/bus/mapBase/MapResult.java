package com.xiankejidaxue.yinjianping.bus.mapBase;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author:yinjianping
 * @Description:路线信息
 * @Date:Created in 19:16 2019/5/12
 * @Modified By:
 */
@Getter
@Setter
public class MapResult {
    //距离
    private Integer distance;
    //时间
    private Integer duration;
    //策略
    private String strategy;

    public MapResult(){
    }
    public MapResult(Integer distance,Integer duration,String strategy){
        this.distance = distance;
        this.duration = duration;
        this.strategy = strategy;
    }
}
