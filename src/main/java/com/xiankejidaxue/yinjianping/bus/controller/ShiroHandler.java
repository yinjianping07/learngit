package com.xiankejidaxue.yinjianping.bus.controller;

import com.xiankejidaxue.yinjianping.bus.result.LoginResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 20:24 2019/4/17
 * @Modified By:
 */
@Controller
public class ShiroHandler {

    @GetMapping(value = "/login")
    public String Login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public LoginResult Login(@RequestParam("userName") String username,
                        @RequestParam("pwd") String password){

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
                //登录操作
                currentUser.login(token);

            }catch (UnknownAccountException exception){
                return new LoginResult(1);
            }catch (IncorrectCredentialsException exception){
                return new LoginResult(2);
            }catch (LockedAccountException exception){
                return new LoginResult(3);
            }catch(AuthenticationException exception){
                //统一处理异常
                System.out.println("登陆失败,原因："+exception.getMessage());
            }
        }
        return new LoginResult(0);
    }

    @GetMapping("/logout")
    public String Logout(){

        System.out.println("logout ====>get");
        //获取subject
        Subject currentUser = SecurityUtils.getSubject();
        //执行等处操作
        currentUser.logout();
        return "login";
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

        System.out.println("Get===================>busList");
        return "busList";
    }
}
