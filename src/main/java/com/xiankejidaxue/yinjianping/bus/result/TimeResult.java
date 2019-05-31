package com.xiankejidaxue.yinjianping.bus.result;

import com.xiankejidaxue.yinjianping.bus.entity.background.TimeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:46 2019/5/28
 * @Modified By:
 */
@Getter
@Setter
public class TimeResult {
    private int success;
    private int status;
    private int count;
    private String msg;
    private List<TimeInfo> timeInfos;

    public TimeResult(){

    }
    public TimeResult(int success,int status,List<TimeInfo> list,int count,String msg){
        this.success = success;
        this.status = status;
        this.timeInfos = list;
        this.count = count;
        this.msg = msg;
    }
}
