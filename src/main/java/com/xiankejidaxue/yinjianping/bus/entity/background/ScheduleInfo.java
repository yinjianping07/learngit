package com.xiankejidaxue.yinjianping.bus.entity.background;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
    private Integer state;
}
