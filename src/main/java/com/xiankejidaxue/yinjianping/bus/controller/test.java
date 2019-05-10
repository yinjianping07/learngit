package com.xiankejidaxue.yinjianping.bus.controller;

import com.xiankejidaxue.yinjianping.bus.entity.UserInfo;
import com.xiankejidaxue.yinjianping.bus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:21 2019/4/22
 * @Modified By:
 */
@RestController
public class test {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    public void test(){

        UserInfo userInfo = new UserInfo();
        String []userNames ={"yinjianping","wangyicheng","yangpeiheng","mayuhao","baijie","liujing","shushijuan","tianzhong","gaoqisong","gaozhan"};

        for (int i = 0;i<10;i++) {
            userInfo.setUid(i);
            userInfo.setName(userNames[i]);
            userInfo.setPassword(String.valueOf((int)(Math.random()*100))+String.valueOf((int)(Math.random()*100)));
            userInfo.setSalt(userInfo.getName());
            userInfo.setState((byte) 1);
            System.out.println(userService.insertAUser(userInfo));
        }
    }

    @GetMapping(value = "/getUsers")
    public void getUsers(){

        Iterator<UserInfo> iterator = userService.findAllUsers().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
