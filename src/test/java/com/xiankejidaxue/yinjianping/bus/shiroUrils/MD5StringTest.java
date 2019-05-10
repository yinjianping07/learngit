package com.xiankejidaxue.yinjianping.bus.shiroUrils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:30 2019/4/24
 * @Modified By:
 */
public class MD5StringTest {

    @Test
    public void getHashAlgorithm() {
        System.out.println(new MD5String("yinjiangping","123456").getString());
    }
}