package com.xiankejidaxue.yinjianping.bus.controller.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.LineInfo;
import com.xiankejidaxue.yinjianping.bus.result.LineResult;
import com.xiankejidaxue.yinjianping.bus.result.SuccessResult;
import com.xiankejidaxue.yinjianping.bus.service.background.LineInfoService;
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
@RequestMapping(value = "/line")
public class LineInfoController {
    @Autowired
    private LineInfoService lineInfoService;

    @GetMapping(value = "/getLineInfos")
    @ResponseBody
    public LineResult getLineInfos(@RequestParam("pageNo")String pageNo){
        int page = Integer.parseInt(pageNo);
        List<LineInfo> list = lineInfoService.findAllLineInfos();
        LineResult lineResult = new LineResult();
        if (list.isEmpty()){
            lineResult.setSuccess(1);
        }else {
            lineResult.setSuccess(0);
            lineResult.setCount(list.size());
            lineResult.setMsg("查询成功");
            lineResult.setLineInfos(this.pages(list,page));
        }
        return lineResult;
    }

    @PostMapping(value = "/save")
    @ResponseBody
    @CrossOrigin
    public SuccessResult save(@RequestParam("sign")String sign,
                              @RequestParam("site")String site,
                              @RequestParam("time")String time,
                              @RequestParam("mileage")String mileage,
                              @RequestParam("siteNumber")String siteNumber){
        SuccessResult successResult = new SuccessResult();

        LineInfo lineInfo = new LineInfo();

        lineInfo.setLineSign(Integer.parseInt(sign));
        lineInfo.setLineSite(site);
        lineInfo.setLineTime(Integer.parseInt(time));
        lineInfo.setLineMileage(Integer.parseInt(mileage));
        lineInfo.setLineSiteNumber(Integer.parseInt(siteNumber));

        //插入
        lineInfo = lineInfoService.saveALine(lineInfo);

        if(lineInfo.equals(null)){
            successResult.setSuccessCode(1);
            successResult.setSuccessMsg("插入失败");
        }else {
            successResult.setSuccessCode(0);
            successResult.setSuccessMsg("插入成功");
        }
        return successResult;
    }

    @GetMapping(value = "/query")
    @ResponseBody
    @CrossOrigin
    public LineResult queryLine(@RequestParam("word")String word,
                                    @RequestParam("pageNo")String pageNo){
        int page = Integer.parseInt(pageNo);
        List<LineInfo> list = lineInfoService.findLineLike(word);
        LineResult lineResult = new LineResult();
        if (list.isEmpty()){
            lineResult.setSuccess(1);
        }else {
            lineResult.setSuccess(0);
            lineResult.setCount(list.size());
            lineResult.setMsg("查询成功");
            lineResult.setLineInfos(this.pages(list,page));
        }
        return lineResult;
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    @CrossOrigin
    public SuccessResult delete(@RequestParam("id")String id){
        lineInfoService.deleteSerivice(Integer.parseInt(id));
        return new SuccessResult(0,"删除成功");
    }

    public List<LineInfo> pages(List<LineInfo> list,int page){

        List<LineInfo> tempList = new ArrayList<>();
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
