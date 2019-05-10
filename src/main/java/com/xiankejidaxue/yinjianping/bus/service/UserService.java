package com.xiankejidaxue.yinjianping.bus.service;

import com.xiankejidaxue.yinjianping.bus.entity.UserInfo;
import com.xiankejidaxue.yinjianping.bus.repository.userInfoRepository;
import com.xiankejidaxue.yinjianping.bus.shiroUrils.MD5String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:12 2019/4/22
 * @Modified By:
 */
@Service
public class UserService {

    @Autowired
    private userInfoRepository useroinfoRepository;

    public UserInfo findAUser(int id){
        Optional<UserInfo> optional = useroinfoRepository.findById(id);
        System.out.println(optional.get());
        return optional.get();
    }

    public UserInfo insertAUser(UserInfo userInfo){

        //存的时候存MD5加密后的
        //MD5加密
        String userName = userInfo.getName();
        String password = userInfo.getPassword();
        password = (new MD5String(userName,password)).getString();
        System.out.println(password);
        userInfo.setPassword(password);

        return useroinfoRepository.save(userInfo);
    }

    public List<UserInfo> findAllUsers(){
        System.out.println("find ---------->allUsers");
        List<UserInfo> userInfos = useroinfoRepository.findAll();
        return userInfos;
    }

    //根据username查找
    public Boolean findAName(String name){
        System.out.println("find this name is ot not");
        return useroinfoRepository.findByName(name).isEmpty();
    }

    //查找status
    public int findThisStatus(String name){
        System.out.println("find this ------------>status");
        UserInfo userInfo = useroinfoRepository.findByName(name).get(0);
        return userInfo.getState();
    }

    //查找password
    public String findThisPassword(String name){

        System.out.println("find this ----->password");
        List<UserInfo> userInfos = useroinfoRepository.findByName(name);
        Iterator<UserInfo> iterator = userInfos.iterator();
        return iterator.next().getPassword();
    }
}
