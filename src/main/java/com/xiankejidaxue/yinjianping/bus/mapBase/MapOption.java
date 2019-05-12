package com.xiankejidaxue.yinjianping.bus.mapBase;

import com.xiankejidaxue.yinjianping.bus.entity.Point;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:yinjianping
 * @Description: 调用高德地图提供和的api获取地点的经纬度坐标，以及两个点之间的行驶时间，路径，距离等。
 * @Date:Created in 16:08 2019/5/12
 * @Modified By:
 */
@Component
@Log4j2
public class MapOption {

    /**
    * @Author:
    * @Description:根据传入返回一个Point
    * @Date: 16:46 2019/5/12
    * @Params: String string
    * @Return :com.xiankejidaxue.yinjianping.bus.entity.Point
    */
    public Point getPoint(String string){
        //创建Http客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();

        Point point = new Point();

        try{
            URIBuilder uriBuilder = new URIBuilder("https://restapi.amap.com/v3/geocode/geo");
            uriBuilder.addParameter("key","251acfb8a2443329f85d869dda607477");
            uriBuilder.addParameter("address",string);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            //获得相应
            CloseableHttpResponse closeableHttpResponse = client.execute(httpGet);

            //获得相应的实体
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            String entityStr = EntityUtils.toString(httpEntity,"UTF-8");

            //处理entityStr
            JSONObject jsonObject = new JSONObject(entityStr);
            JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
            String location = jsonArray.getJSONObject(0).getString("location");

            point.setLongitude(doubleLocation(location).get(0));
            point.setLatitude(doubleLocation(location).get(1));
            point.setLocation(string);
        }catch(JSONException e){
            log.info("JSONException");
        }catch(URISyntaxException e){
            log.info("URISyntaxException");
        }catch (ClientProtocolException e){
            log.info("ClientProtocolException");
        }catch (IOException e){
            log.info("IOException");
        }finally {
            try{
                client.close();
            }catch(IOException e){
                log.info("连接释放错误"+ e.getMessage());
            }
        }
        return point;
    }

    /**
    * @Author:yinjianping
    * @Description: String转换Double
    * @Date: 18:26 2019/5/12
    * @Params:
    * @Return:
    */
    public List<Double> doubleLocation(String string){
        String [] strings = string.split(",");
        List<Double> list = new ArrayList<>(Arrays.asList(
                new Double[]{Double.parseDouble(strings[0]),
                        Double.parseDouble(strings[1])}));
        return list;
    }

    /**
    * @Author:yinjianping
    * @Description: 两个地点之间的路线信息
    * @Date: 18:27 2019/5/12
    * @Params: Point origin,Point destination
    * @Return :Integer
    */
    public List<MapResult> getBetween(Point origin,Point destination){

        List<MapResult> pathList = new LinkedList<>();

        try(CloseableHttpClient client = HttpClientBuilder.create().build();
        ){
            URIBuilder uriBuilder = new URIBuilder("https://restapi.amap.com/v3/geocode/geo");

            List<NameValuePair> list = new LinkedList<>();

            BasicNameValuePair param1 = new BasicNameValuePair("key","251acfb8a2443329f85d869dda607477");
            BasicNameValuePair param2 = new BasicNameValuePair("extensions","base");
            BasicNameValuePair param3 = new BasicNameValuePair("origin",
                    stringLocation(origin.getLongitude(),origin.getLatitude()));
            BasicNameValuePair param4 = new BasicNameValuePair("destination",
                    stringLocation(destination.getLongitude(),destination.getLatitude()));

            list.add(param1);
            list.add(param2);
            list.add(param3);
            list.add(param4);

            uriBuilder.setParameters(list);

            // 根据带参数的URI对象构建GET请求对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());

            //获得返回
            CloseableHttpResponse response = client.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String entityStr = EntityUtils.toString(entity,"UTF-8");

            JSONObject jsonObject = new JSONObject(entityStr);
            JSONArray paths = jsonObject.getJSONObject("route").getJSONArray("paths");
            for (Object object : paths){
                JSONObject temp = new JSONObject(object);
                Integer distance = Integer.valueOf(temp.getString("distance"));
                Integer duration = Integer.valueOf(temp.getString("duration"));
                String strategy = temp.getString("strategy");
                pathList.add(new MapResult(distance,duration,strategy));
            }


        }catch(IOException e){
            log.info("IOException");
        }catch(URISyntaxException e){
            log.info("URISyntaxException");
        }
        return pathList;
    }
    public String stringLocation(Double double1,Double double2){
        return String.valueOf(double1)+String.valueOf(double2);
    }
}
