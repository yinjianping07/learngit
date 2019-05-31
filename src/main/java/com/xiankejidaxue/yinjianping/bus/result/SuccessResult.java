package com.xiankejidaxue.yinjianping.bus.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 14:38 2019/5/27
 * @Modified By:
 */
@Getter
@Setter
public class SuccessResult {
    private int successCode;
    private String successMsg;

    public SuccessResult(int successCode,String msg){
        this.successCode = successCode;
        this.successMsg = msg;
    }
    public SuccessResult(){}
}
