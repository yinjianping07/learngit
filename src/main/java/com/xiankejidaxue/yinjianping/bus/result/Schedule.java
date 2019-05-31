package com.xiankejidaxue.yinjianping.bus.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 15:47 2019/5/28
 * @Modified By:
 */
@Getter
@Setter
public class Schedule {
    private String driverName;
    private String lineInfo;
    private String time;
    private String driverSiteNumber;
    private int now;
    private int number;

    public Schedule(){}
    public Schedule(String driverName,String lineInfo,String time,String driverSiteNumber,int now,int number){
        this.driverName = driverName;
        this.lineInfo = lineInfo;
        this.time = time;
        this.driverSiteNumber = driverSiteNumber;
        this.now = now;
        this.number = number;
    }
}
