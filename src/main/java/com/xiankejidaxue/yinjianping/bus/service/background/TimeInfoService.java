package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.TimeInfo;
import com.xiankejidaxue.yinjianping.bus.repository.background.TimeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:31 2019/5/28
 * @Modified By:
 */
@Service
public class TimeInfoService {

    @Autowired
    private TimeInfoRepository timeInfoRepository;

    public List<TimeInfo> findAllTime(){
        return timeInfoRepository.findAll();
    }

    public TimeInfo saveATime(TimeInfo timeInfo){
        return timeInfoRepository.save(timeInfo);
    }

    public TimeInfo findATime(Integer id){
        return timeInfoRepository.findById(id).get();
    }

    public void deleteSerivice(int id){
        timeInfoRepository.deleteById(id);
    }
}
