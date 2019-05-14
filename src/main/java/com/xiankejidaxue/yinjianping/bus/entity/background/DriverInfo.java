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
 * @Date:Created in 17:18 2019/5/14
 * @Modified By:
 */
@Entity(name = "driver_info")
@Getter
@Setter
@ToString
public class DriverInfo {

    @Id
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_age")
    private Integer driverAge;

    @Column(name = "driver_sex")
    private String driverSex;

    @Column(name = "driver_telphone")
    private Integer driverTelphone;

    @Column(name = "driver_landline")
    private String driverLandLine;

    @Column(name = "driver_location")
    private String driverLocation;

    @Column(name = "driver_number")
    private String driverNumber;

    @Column(name = "driver_limit")
    private Integer driverLimit;

    @Column(name = "driver_employ")
    private Integer driverEmploy;

    @Column(name = "driver_comment")
    private String driverComment;

    @Column(name = "driver_in_use")
    private Integer driverInUse;
}
