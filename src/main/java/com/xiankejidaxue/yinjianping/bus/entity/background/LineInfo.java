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
 * @Date:Created in 17:40 2019/5/14
 * @Modified By:
 */
@Entity(name = "line_info")
@Getter
@Setter
@ToString
public class LineInfo {

    @Id
    @Column(name = "line_id")
    private Integer lineId;

    @Column(name = "line_sign")
    private Integer lineSign;

    @Column(name = "line_site")
    private String lineSite;

    @Column(name = "line_time")
    private Integer lineTime;

    @Column(name = "line_mileage")
    private Integer lineMileage;

    @Column(name = "line_site_number")
    private Integer lineSiteNumber;

}
