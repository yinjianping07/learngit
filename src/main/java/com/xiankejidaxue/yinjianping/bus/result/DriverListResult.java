package com.xiankejidaxue.yinjianping.bus.result;


import com.xiankejidaxue.yinjianping.bus.entity.background.DriverInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:54 2019/5/27
 * @Modified By:
 */
@Getter
@Setter
public class DriverListResult {
    private int success;
    private int status;
    private int count;
    private List<DriverInfo> driverInfos;
    private String msg;

    public DriverListResult(){

    }
    public DriverListResult(int success, int status, List<DriverInfo> list, int count,String msg){
        this.success = success;
        this.status = status;
        this.driverInfos = list;
        this.count = count;
        this.msg = msg;
    }
}
