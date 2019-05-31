package com.xiankejidaxue.yinjianping.bus.result;

import com.xiankejidaxue.yinjianping.bus.entity.background.LineInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:45 2019/5/28
 * @Modified By:
 */
@Getter
@Setter
public class LineResult {
    private int success;
    private int status;
    private int count;
    private String msg;
    private List<LineInfo> lineInfos;

    public LineResult(){

    }
    public LineResult(int success,int status,List<LineInfo> list,int count,String msg){
        this.success = success;
        this.status = status;
        this.lineInfos = list;
        this.count = count;
        this.msg = msg;
    }
}

