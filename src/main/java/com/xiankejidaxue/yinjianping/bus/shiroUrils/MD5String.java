package com.xiankejidaxue.yinjianping.bus.shiroUrils;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 16:46 2019/4/22
 * @Modified By:
 */
@Getter
@Setter
public class MD5String {

    private String string;

    public MD5String(){
        this.string = "";
    }

    public MD5String(String userName,String password){
        String hashAlgorithmName = "MD5";
        Object credentias = password;
        Object salt = ByteSource.Util.bytes(userName);
        int hashIterations = 1024;
        this.string = String.valueOf(new SimpleHash(hashAlgorithmName,credentias,salt,hashIterations));
    }

    public String getHashAlgorithm(String realmName, String password){
        String hashAlgorithmName = "MD5";
        Object credentias = password;
        Object salt = ByteSource.Util.bytes(realmName);
        int hashIterations = 1024;
        System.out.println(new SimpleHash(hashAlgorithmName,credentias,salt,hashIterations));
        return String.valueOf(new SimpleHash(hashAlgorithmName,credentias,salt,hashIterations));
    }
}
