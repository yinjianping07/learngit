package com.xiankejidaxue.yinjianping.bus.service.background;

import com.xiankejidaxue.yinjianping.bus.entity.background.LineInfo;
import com.xiankejidaxue.yinjianping.bus.repository.background.LineInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 12:10 2019/5/28
 * @Modified By:
 */
@Service
public class LineInfoService {
    @Autowired
    private LineInfoRepository lineInfoRepository;

    public List<LineInfo> findAllLineInfos(){
        return lineInfoRepository.findAll();
    }

    public List<LineInfo> findLineLike(String site){
        return lineInfoRepository.findByLineSiteLike("%"+site+"%");
    }

    public LineInfo saveALine(LineInfo lineInfo){
        return lineInfoRepository.save(lineInfo);
    }

    public LineInfo findALine(Integer id){
        return lineInfoRepository.findById(id).get();
    }
    public void deleteSerivice(int id){
        lineInfoRepository.deleteById(id);
    }
}
