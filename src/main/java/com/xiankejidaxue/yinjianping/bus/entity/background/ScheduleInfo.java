package com.xiankejidaxue.yinjianping.bus.entity.background;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 17:45 2019/5/14
 * @Modified By:
 */
@Entity(name = "schedule_info")
@Getter
@Setter
@ToString
public class ScheduleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "time_id")
    private Integer timeId;

    @Column(name = "bus_id")
    private Integer busId;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "line_id")
    private Integer lineId;

    @Column(name = "state")
    private Integer state = 0;

    @Column(name = "number",columnDefinition = "int(5) default 0 comment '该班次的实际运行的人数'")
    private Integer number;
}
