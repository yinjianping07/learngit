package com.xiankejidaxue.yinjianping.bus.controller.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.TimeInfo;
import com.xiankejidaxue.yinjianping.bus.result.SuccessResult;
import com.xiankejidaxue.yinjianping.bus.result.TimeResult;
import com.xiankejidaxue.yinjianping.bus.service.background.TimeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:38 2019/5/28
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/time")
public class TimeInfoController {

    @Autowired
    private TimeInfoService timeInfoService;

    @GetMapping(value = "/getTimeInfos")
    @ResponseBody
    public TimeResult getTimeInfos(@RequestParam("pageNo")String pageNo){
        int page = Integer.parseInt(pageNo);

        List<TimeInfo> list = timeInfoService.findAllTime();
        TimeResult timeResult = new TimeResult();
        if (list.isEmpty()){
            timeResult.setSuccess(1);
        }else {
            timeResult.setSuccess(0);
            timeResult.setCount(list.size());
            timeResult.setMsg("查询成功");
            timeResult.setTimeInfos(this.pages(list,page));
        }
        return timeResult;
     }

    @PostMapping(value = "/save")
    @ResponseBody
    @CrossOrigin
    public SuccessResult save(@RequestParam("timePoint")String timePoint){
        SuccessResult successResult = new SuccessResult();

        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setTimePoint(timePoint);

        timeInfo = timeInfoService.saveATime(timeInfo);
        if(timeInfo.equals(null)){
            successResult.setSuccessCode(1);
            successResult.setSuccessMsg("插入失败");
        }else {
            successResult.setSuccessCode(0);
            successResult.setSuccessMsg("插入成功");
        }
        return successResult;
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    @CrossOrigin
    public SuccessResult delete(@RequestParam("id")String id){
        timeInfoService.deleteSerivice(Integer.parseInt(id));
        return new SuccessResult(0,"删除成功");
    }

    public List<TimeInfo> pages(List<TimeInfo> list,int page){

        List<TimeInfo> tempList = new ArrayList<>();
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
