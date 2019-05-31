package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.DriverInfo;
import com.xiankejidaxue.yinjianping.bus.repository.background.DriverInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:48 2019/5/27
 * @Modified By:
 */
@Service
public class DriverInfoService {
    @Autowired
    private DriverInfoRepository driverInfoRepository;

    public DriverInfo findADriver(Integer id){
        return driverInfoRepository.findById(id).get();
    }

    public List<DriverInfo> findAllDriverInfo(){
        return driverInfoRepository.findAll();
    }

    public DriverInfo saveADriver(DriverInfo driverInfo){
        return driverInfoRepository.save(driverInfo);
    }

    public List<DriverInfo> findNameLike(String name){
        return driverInfoRepository.findByDriverNameLike("%"+name+"%");
    }

    public void deleteSerivice(int id){
        driverInfoRepository.deleteById(id);
    }
}
