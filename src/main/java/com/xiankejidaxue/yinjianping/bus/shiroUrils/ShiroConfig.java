package com.xiankejidaxue.yinjianping.bus.shiroUrils;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:18 2019/4/17
 * @Modified By:
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        System.out.println("ShiroConfiguration.shirFilter()");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        filterChainDefinitionMap.put("/bus/**","anon");
        filterChainDefinitionMap.put("/driver/**","anon");
        filterChainDefinitionMap.put("/schedule/**","anon");
        filterChainDefinitionMap.put("/time/**","anon");
        filterChainDefinitionMap.put("/line/**","anon");
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/index","anon");
        filterChainDefinitionMap.put("/assets/**","anon");
        filterChainDefinitionMap.put("login.html","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/busList");
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/pages/**", "anon");
//        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/pages/logout", "logout");
//        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑，一不小心代码就不好使了;
//        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/pages/**", "authc");
//        // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
//        shiroFilterFactoryBean.setLoginUrl("/pages/login");
//        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/pages/success");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 哈希密码比较器。在myShiroRealm中作用参数使用
     * 登陆时会比较用户输入的密码，跟数据库密码配合盐值salt解密后是否一致。
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用md5算法;
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数，比如散列两次，相当于 md5( md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroRealm myShiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }


    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * Shiro生命周期处理器
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 自动创建代理
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
}
