package com.xiankejidaxue.yinjianping.bus.exception;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 11:11 2019/5/21
 * @Modified By:
 */
public class PathFoundFailException extends RuntimeException{

    private static final long serialVersionUID = -7061823093360979642L;

    public PathFoundFailException(){
        super();
    }
    public PathFoundFailException(String msg){
        super(msg);
    }
}
