package com.xiankejidaxue.yinjianping.bus.controller.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.LineInfo;
import com.xiankejidaxue.yinjianping.bus.entity.background.ScheduleInfo;
import com.xiankejidaxue.yinjianping.bus.result.Schedule;
import com.xiankejidaxue.yinjianping.bus.result.ScheduleResult;
import com.xiankejidaxue.yinjianping.bus.result.SuccessResult;
import com.xiankejidaxue.yinjianping.bus.service.background.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:38 2019/5/28
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/schedule")
public class ScheduleInfoController {
    @Autowired
    private ScheduleInfoService scheduleInfoService;

    @Autowired
    private DriverInfoService driverInfoService;

    @Autowired
    private TimeInfoService timeInfoService;

    @Autowired
    private LineInfoService lineInfoService;

    @Autowired
    private BusInfoService busInfoService;

    @GetMapping(value = "/getScheduleInfos")
    @ResponseBody
    public ScheduleResult getTimeInfos(@RequestParam("pageNo")String pageNo){
        int page = Integer.parseInt(pageNo);

        List<ScheduleInfo> list = scheduleInfoService.findAllScheduleInfo();
        return makeResult(list,page);
    }

    @GetMapping(value = "/query")
    @ResponseBody
    @CrossOrigin
    public ScheduleResult query(@RequestParam("word")String word,
                                @RequestParam("pageNo")String pageNo){
        int page = Integer.parseInt(pageNo);
        List<LineInfo> lineInfos = lineInfoService.findLineLike(word);
        Iterator<LineInfo> iterator = lineInfos.iterator();

        List<ScheduleInfo> scheduleList = new ArrayList<>();
        while (iterator.hasNext()){
            scheduleList.addAll(scheduleInfoService.findByLineId(iterator.next().getLineId()));
        }
        return makeResult(scheduleList,page);
    }

    @PostMapping(value = "/save")
    @ResponseBody
    @CrossOrigin
    public SuccessResult save(@RequestParam("timeId")String timeId,
                              @RequestParam("busId")String busId,
                              @RequestParam("driverId")String driverId,
                              @RequestParam("lineId")String lineId){
        SuccessResult successResult = new SuccessResult();

        ScheduleInfo scheduleInfo = new ScheduleInfo();
        scheduleInfo.setBusId(Integer.parseInt(busId));
        scheduleInfo.setLineId(Integer.parseInt(lineId));
        scheduleInfo.setDriverId(Integer.parseInt(driverId));
        scheduleInfo.setTimeId(Integer.parseInt(timeId));
        //状态默认新插入为0
        scheduleInfo.setState(0);

        scheduleInfo = scheduleInfoService.saveAScehduleInfo(scheduleInfo);

        if(scheduleInfo.equals(null)){
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
        scheduleInfoService.deleteSerivice(Integer.parseInt(id));
        return new SuccessResult(0,"删除成功");
    }

    public ScheduleResult makeResult(List<ScheduleInfo> list,int page){
        Iterator<ScheduleInfo> iterator = list.iterator();

        List<Schedule> schedulelist = new ArrayList<>();
        while (iterator.hasNext()){
            ScheduleInfo scheduleInfo = iterator.next();
            Schedule schedule = new Schedule();

            String driverName = driverInfoService.findADriver(scheduleInfo.getDriverId()).getDriverName();
            String time = timeInfoService.findATime(scheduleInfo.getTimeId()).getTimePoint();
            String lineIfo = lineInfoService.findALine(scheduleInfo.getLineId()).getLineSite();
            int bus = busInfoService.findABusInfo(scheduleInfo.getBusId()).getBusSiteNumber();

            schedule.setDriverName(driverName);
            schedule.setTime(time);
            schedule.setLineInfo(lineIfo);
            schedule.setDriverSiteNumber(String.valueOf(bus));
            schedule.setNow(scheduleInfo.getState());
            schedule.setNumber(scheduleInfo.getNumber());

            schedulelist.add(schedule);
        }
        ScheduleResult scheduleResult = new ScheduleResult();
        if (list.isEmpty()){
            scheduleResult.setSuccess(1);
        }else {
            scheduleResult.setSuccess(0);
            scheduleResult.setCount(list.size());
            scheduleResult.setMsg("查询成功");
            scheduleResult.setScheduleInfos(this.pages(schedulelist,page));
        }
        return scheduleResult;
    }

    public List<Schedule> pages(List<Schedule> list,int page){

        List<Schedule> tempList = new ArrayList<>();
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
