package com.xiankejidaxue.yinjianping.bus.controller.background;

import com.xiankejidaxue.yinjianping.bus.service.MapOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 22:23 2019/5/23
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/wx")
public class MapOptionController {
    @Autowired
    private MapOptionService mapOptionService;

    @PostMapping(value = "/getDuration")
    public String getDuration(@RequestParam("originLocation")String originLocation,
                              @RequestParam("destinationLocation")String destinationLocation){
        return mapOptionService.getBetweenService(mapOptionService.getPointService(originLocation),
                mapOptionService.getPointService(destinationLocation)).toString();
    }
}
