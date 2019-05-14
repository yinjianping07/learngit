package com.xiankejidaxue.yinjianping.bus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author:yinjianping
 * @Description: 经度纬度
 * @Date:Created in 16:19 2019/5/12
 * @Modified By:
 */
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "point")
public class Point {
    @Id
    @Column(name = "id")
    private Integer id;

    //经度
    @Column(name = "longitude")
    private Double longitude;

    //纬度
    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "location")
    private String location;

}
