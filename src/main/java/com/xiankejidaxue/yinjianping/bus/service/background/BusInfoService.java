package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.BusInfo;
import com.xiankejidaxue.yinjianping.bus.repository.background.BusInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 22:44 2019/5/15
 * @Modified By:
 */
@Service
public class BusInfoService {
    @Autowired
    private BusInfoRepository busInfoRepository;

    public BusInfo findABusInfo(Integer id){
        return busInfoRepository.findById(id).get();
    }

    public List<BusInfo> findAllBusInfo(){
        return busInfoRepository.findAll();
    }

    public BusInfo saveBusInfo(BusInfo busInfo){
        return busInfoRepository.save(busInfo);
    }

    public void delteService(int id){
        busInfoRepository.deleteById(id);
    }

    public List<BusInfo> findNameLike(String name){
        return busInfoRepository.findLikeName("%"+name+"%");
    }
}
