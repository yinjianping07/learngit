package com.xiankejidaxue.yinjianping.bus.result;

import com.xiankejidaxue.yinjianping.bus.entity.background.BusInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 9:27 2019/5/27
 * @Modified By:
 */
@Getter
@Setter
public class BusListResult {
    private int success;
    private int status;
    private int count;
    private String msg;
    private List<BusInfo> busInfos;

    public BusListResult(){

    }
    public BusListResult(int success,int status,List<BusInfo> list,int count,String msg){
        this.success = success;
        this.status = status;
        this.busInfos = list;
        this.count = count;
        this.msg = msg;
    }
}
