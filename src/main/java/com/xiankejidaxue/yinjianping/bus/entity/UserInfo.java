package com.xiankejidaxue.yinjianping.bus.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 14:55 2019/3/17
 * @Modified By:
 */

@Entity
@Table(name = "user_info")
@Getter
@Setter
@ToString
public class UserInfo {

    @Id
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "name")
    private String username;//帐号
    @Column(name = "username")
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    @Column(name = "password")
    private String password; //密码;
    @Column(name = "salt")
    private String salt;//加密密码的盐
    @Column(name = "status")
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
}
