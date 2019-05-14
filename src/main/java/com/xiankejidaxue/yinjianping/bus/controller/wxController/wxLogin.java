package com.xiankejidaxue.yinjianping.bus.controller.wxController;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 9:43 2019/5/14
 * @Modified By:
 */
@RestController
@Log4j2
public class wxLogin {

    @PostMapping(value = "/wxLogin")
    public String wxLogin(@RequestParam("code")String code){

        log.info("wxLogin - code: " + code);


        try(
                //创建Http客户端
            CloseableHttpClient client = HttpClientBuilder.create().build();)
        {
            //执行逻辑
            URIBuilder uriBuilder = new URIBuilder("https://api.weixin.qq.com/sns/jscode2session");
            uriBuilder.addParameter("appid","wx957d904b87d4d719");
            uriBuilder.addParameter("secret","83ca6b98e72a5bbfcf69d6ce7c280f7b");
            uriBuilder.addParameter("js_code",code);
            uriBuilder.addParameter("grant_type","authorization_code");

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            CloseableHttpResponse response = client.execute(httpGet);

            //获得相应的实体
            HttpEntity httpEntity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            String wxResult = EntityUtils.toString(httpEntity,"UTF-8");

            log.info(wxResult);
            System.out.println(wxResult);

            System.out.println(new JSONObject(wxResult));

            return wxResult;

        }catch (IOException e){

        }catch(URISyntaxException e){

        }
        return null;
    }
}
