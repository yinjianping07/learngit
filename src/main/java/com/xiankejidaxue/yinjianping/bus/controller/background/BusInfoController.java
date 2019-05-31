package com.xiankejidaxue.yinjianping.bus.controller.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.BusInfo;
import com.xiankejidaxue.yinjianping.bus.result.BusListResult;
import com.xiankejidaxue.yinjianping.bus.result.SuccessResult;
import com.xiankejidaxue.yinjianping.bus.service.background.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 9:38 2019/5/27
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/bus")
public class BusInfoController {
    @Autowired
    private BusInfoService busInfoService;

    @GetMapping(value = "/getBusInfos")
    @ResponseBody
    @CrossOrigin
    public BusListResult getBusInfos(@RequestParam("pageNo")String pageNo){
        int page = Integer.parseInt(pageNo);
        List<BusInfo> list = busInfoService.findAllBusInfo();
        BusListResult busListResult = new BusListResult();
        if (list.isEmpty()){
            busListResult.setSuccess(1);
        }else {
            busListResult.setSuccess(0);
            busListResult.setCount(list.size());
            busListResult.setMsg("查询成功");
            busListResult.setBusInfos(this.pages(list,page));
        }
        return busListResult;
    }

    @PostMapping(value = "/save")
    @ResponseBody
    @CrossOrigin
    public SuccessResult save(@RequestParam("siteNumber")String siteNumber,
                               @RequestParam("brand")String brand,
                               @RequestParam("license")String license,
                               @RequestParam("year")String year,
                               @RequestParam("lease")String lease,
                               @RequestParam("company")String company,
                               @RequestParam("life")String life){
        SuccessResult successResult = new SuccessResult();

        BusInfo busInfo = new BusInfo();

        busInfo.setBusSiteNumber(Integer.valueOf(siteNumber));
        busInfo.setBusBrand(brand);
        busInfo.setBusLicense(license);
        busInfo.setBusYear(Integer.valueOf(year));
        busInfo.setBusLease(Integer.valueOf(lease));
        busInfo.setBusInsuranceCompany(company);
        busInfo.setBusInUse(0);
        busInfo.setBusInsuranceLife(Integer.valueOf(life));

        busInfo = busInfoService.saveBusInfo(busInfo);
        if(busInfo.equals(null)){
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
    public BusListResult queryBus(@RequestParam("word")String word,
                                  @RequestParam("pageNo")String pageNo){
        int page;
        if ("".equals(pageNo)){
            page = 1;
        }else {
            page = Integer.parseInt(pageNo);
        }
        List<BusInfo> list =  busInfoService.findNameLike(word);
        //分页
        return new BusListResult(0,0,this.pages(list,page),list.size(),"查询成功");
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    @CrossOrigin
    public SuccessResult delete(@RequestParam("id")String id){
        busInfoService.delteService(Integer.parseInt(id));
        return new SuccessResult(0,"删除成功！");
    }


    /**
    * @Author:yinjianping
    * @Description:分页处理
    * @Date: 11:09 2019/5/28
    * @Params:
    * @Return :
    */
    public List<BusInfo> pages(List<BusInfo> list,int page){

        List<BusInfo> tempList = new ArrayList<>();
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
