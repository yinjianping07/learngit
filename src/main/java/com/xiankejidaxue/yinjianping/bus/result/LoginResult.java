package com.xiankejidaxue.yinjianping.bus.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:33 2019/5/26
 * @Modified By:
 */
@Setter
@Getter
public class LoginResult {
    private int success;
    private int status;

    public LoginResult(){
        this.status = 0;
    }
    public LoginResult(int code){
        this.success = code;
        this.status = 0;
    }
}
