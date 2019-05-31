package com.xiankejidaxue.yinjianping.bus.result;

import com.xiankejidaxue.yinjianping.bus.entity.background.ScheduleInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:47 2019/5/28
 * @Modified By:
 */
@Getter
@Setter
public class ScheduleResult {

    private int success;
    private int status;
    private int count;
    private String msg;
    private List<Schedule> scheduleInfos;

    public ScheduleResult(){

    }
    public ScheduleResult(int success,int status,List<Schedule> list,int count,String msg){
        this.success = success;
        this.status = status;
        this.scheduleInfos = list;
        this.count = count;
        this.msg = msg;
    }
}
