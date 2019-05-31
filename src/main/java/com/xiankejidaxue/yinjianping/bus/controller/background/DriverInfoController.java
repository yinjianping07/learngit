package com.xiankejidaxue.yinjianping.bus.controller.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.DriverInfo;
import com.xiankejidaxue.yinjianping.bus.result.DriverListResult;
import com.xiankejidaxue.yinjianping.bus.result.SuccessResult;
import com.xiankejidaxue.yinjianping.bus.service.background.DriverInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:46 2019/5/27
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/driver")
public class DriverInfoController {
    @Autowired
    private DriverInfoService driverInfoService;

    @GetMapping(value = "/getDriverInfos")
    @ResponseBody
    @CrossOrigin
    public DriverListResult getDriverInfos(@RequestParam("pageNo")String pageNo){

        int page = Integer.parseInt(pageNo);

        List<DriverInfo> list = driverInfoService.findAllDriverInfo();
        DriverListResult driverListResult = new DriverListResult();

        if (list.size() == 0){
            driverListResult.setSuccess(1);
            driverListResult.setStatus(0);
            driverListResult.setCount(list.size());
            driverListResult.setMsg("没有相关班车信息");
        }else {
            driverListResult.setSuccess(0);
            driverListResult.setStatus(0);
            driverListResult.setCount(list.size());
            driverListResult.setMsg("查询成功");
            driverListResult.setDriverInfos(this.pages(list,page));

        }
        return driverListResult;
    }

    @GetMapping(value = "/query")
    @ResponseBody
    @CrossOrigin
    public DriverListResult queryBus(@RequestParam("word")String word,
                                  @RequestParam("pageNo")String pageNo){
        int page;
        if ("".equals(pageNo)){
            page = 1;
        }else {
            page = Integer.parseInt(pageNo);
        }
        List<DriverInfo> list =  driverInfoService.findNameLike(word);
        //分页
        return new DriverListResult(0,0,this.pages(list,page),list.size(),"查询成功");
    }

    @PostMapping(value = "/saveDriver")
    @ResponseBody
    @CrossOrigin
    public SuccessResult saveDriver(@RequestParam("name")String name,
                                    @RequestParam("age")String age,
                                    @RequestParam("sex")String sex,
                                    @RequestParam("telphone")String telphone,
                                    @RequestParam("landline")String landline,
                                    @RequestParam("location")String location,
                                    @RequestParam("number")String number,
                                    @RequestParam("limit")String limit,
                                    @RequestParam("employ")String employ,
                                    @RequestParam("comment")String comment){
        SuccessResult successResult = new SuccessResult();

        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setDriverName(name);
        driverInfo.setDriverAge(Integer.valueOf(age));
        driverInfo.setDriverSex(sex);
        driverInfo.setDriverTelphone(telphone);
        driverInfo.setDriverLandLine(landline);
        driverInfo.setDriverLocation(location);
        driverInfo.setDriverNumber(number);
        driverInfo.setDriverLimit(Integer.valueOf(limit));
        driverInfo.setDriverEmploy(Integer.valueOf(employ));
        driverInfo.setDriverComment(comment);
        driverInfo.setDriverInUse(0);

        driverInfo = driverInfoService.saveADriver(driverInfo);
        if (driverInfo.equals(null)){
            successResult.setSuccessCode(1);
            successResult.setSuccessMsg("插入失败");
        }else {
            successResult.setSuccessMsg("插入成功");
            successResult.setSuccessCode(0);
        }
        return successResult;
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    @CrossOrigin
    public SuccessResult delete(@RequestParam("id")String id){
        driverInfoService.deleteSerivice(Integer.parseInt(id));
        return new SuccessResult(0,"删除成功");
    }


    public List<DriverInfo> pages(List<DriverInfo> list,int page){

        List<DriverInfo> tempList = new ArrayList<>();
        //如果总数少于10，都分在第一页
        if (list.size()<=10){
            tempList = list;
        }
        //大于10
        if (list.size()>10){
            //处理最后一页
            if (page*10-1>list.size()){
                for (int i = (page-1)*10;i<list.size();i++){
                    tempList.add(list.get(i));
                }
            }else {
                for (int i = (page-1)*10;i<page*10;i++){
                    tempList.add(list.get(i));
                }
            }
        }
        return tempList;
    }
}
