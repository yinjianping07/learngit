package com.xiankejidaxue.yinjianping.bus.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;


/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 20:24 2019/4/17
 * @Modified By:
 */
@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

    @GetMapping(value = "/index")
    public String Login(){
        System.out.println("login ===>GET");
        return "index";
    }

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){

        System.out.println("request:/login=====>post");
        System.out.println(username+"--------->"+password);

        //获取subject
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            //将用户名和密码封装成
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            //remember
            token.setRememberMe(true);
            try{
                currentUser.login(token);
            }catch (UnknownAccountException exception){
                model.addAttribute("msg","账户名不存在");
                return "index";
            }catch (IncorrectCredentialsException exception){
                model.addAttribute("msg","密码错误");
                return "index";
            }catch (LockedAccountException exception){
                model.addAttribute("msg","账户被锁定");
                return "index";
            }catch(AuthenticationException exception){
                //统一处理异常
                System.out.println("登陆失败,原因："+exception.getMessage());
                model.addAttribute("msg",exception.getMessage());
                return "index";
            }
        }
        return "busList";
    }
    @GetMapping("/logout")
    public String Logout(){

        System.out.println("logout ====>get");
        //获取subject
        Subject currentUser = SecurityUtils.getSubject();
        //执行等处操作
        currentUser.logout();
        return "index";
    }

    @GetMapping(value = "/timeList")
    public String timeList(){
        System.out.println("Get===================>timeList");
        return "timeList";
    }

    @GetMapping(value = "/driverList")
    public String driverList(){

        System.out.println("driverList==========>get");
        return "driverList";
    }

    @GetMapping(value = "/lineList")
    public String lineList(){
        System.out.println("Get===================>lineList");
        return "lineList";
    }

    @GetMapping(value = "/busList")
    public String busList(){

        //HashSet<Character> set = new HashSet(Arrays.asList(new Character[]{'A','B','E'}));

        System.out.println("Get===================>busList");
        return "busList";
    }
}
