package com.xiankejidaxue.yinjianping.bus.controller;

import com.xiankejidaxue.yinjianping.bus.entity.UserInfo;
import com.xiankejidaxue.yinjianping.bus.service.OpenCVService;
import com.xiankejidaxue.yinjianping.bus.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.descriptor.web.WebXml;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:21 2019/4/22
 * @Modified By:
 */
@RestController
@Log4j2
public class test {

    @Autowired
    private UserService userService;

    @Autowired
    private OpenCVService openCVService;

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

    @GetMapping(value = "/opencv")
    public String opencvTest(){
        int num = openCVService.getFaceNum();
        return String.valueOf(num);
    }
}
