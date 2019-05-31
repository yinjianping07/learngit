package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.ScheduleInfo;
import com.xiankejidaxue.yinjianping.bus.repository.background.ScheduleInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:34 2019/5/28
 * @Modified By:
 */
@Service
public class ScheduleInfoService {

    @Autowired
    private ScheduleInfoRepository scheduleInfoRepository;

    public List<ScheduleInfo> findAllScheduleInfo(){
        return scheduleInfoRepository.findAll();
    }

    public ScheduleInfo saveAScehduleInfo(ScheduleInfo scheduleInfo){
        return scheduleInfoRepository.save(scheduleInfo);
    }

    public List<ScheduleInfo> findByLineId(int id){
        return scheduleInfoRepository.findByLineId(id);
    }
    public void deleteSerivice(int id){
        scheduleInfoRepository.deleteById(id);
    }
}
