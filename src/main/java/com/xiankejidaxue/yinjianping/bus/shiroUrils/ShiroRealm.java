package com.xiankejidaxue.yinjianping.bus.shiroUrils;

import com.xiankejidaxue.yinjianping.bus.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 16:47 2019/4/17
 * @Modified By:
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        System.out.println("doGetAuthenticationInfo"+token);

        //1.把AuthenticationToken类型的token转换成
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();

        System.out.println("username: "+usernamePasswordToken.getUsername()+"------>password: "
                +usernamePasswordToken.getPassword());

        if (userService.findAName(username)){
            System.out.println("用户名不存在");
            throw new UnknownAccountException("用户名不存在");
        }
        if (userService.findThisStatus(username) == 1){
            throw new LockedAccountException("用户被锁定");
        }

        //以下信息是从数据库中获取
        System.out.println(usernamePasswordToken.getUsername());
        Object principal = usernamePasswordToken.getUsername();

        //加密MD5
        //替换当前的realm的credentialsMatcher属性，直接使用HashedCredentialsMatcher 对象，并设置属性加密算法
        System.out.println(userService.findThisPassword(username));
        //Object credentials = userService.findThisPassword(username);//getHashAlgorithm(getName(),"123456");
        //Object credentials = "96903c8257ebb6cfde21f406a0c8589c";

        Object credentials = (new MD5String("yinjiangping","123456")).getString();
        String realmName = getName();

        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(realmName);

        SimpleAuthenticationInfo info = null;//new SimpleAuthenticationInfo(principal,credentials,realmName);
        info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
        System.out.println(info);
        return info;
    }
}
