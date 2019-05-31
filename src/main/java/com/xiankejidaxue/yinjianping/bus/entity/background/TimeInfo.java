package com.xiankejidaxue.yinjianping.bus.entity.background;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 18:28 2019/5/14
 * @Modified By:
 */
@Entity(name = "time_info")
@Getter
@Setter
@ToString
public class TimeInfo {
    @Id
    @Column(name = "time_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer timeId;

    @Column(name = "time_point")
    private String timePoint;
}
