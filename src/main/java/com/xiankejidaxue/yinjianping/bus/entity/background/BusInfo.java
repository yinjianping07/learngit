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
 * @Date:Created in 16:44 2019/5/14
 * @Modified By:
 */
@Entity(name = "bus_info")
@Getter
@Setter
@ToString
public class BusInfo {
    @Id
    @Column(name = "bus_id")
    private Integer busId;

    @Column(name = "bus_site_number")
    private Integer busSiteNumber;

    @Column(name = "bus_brand")
    private String busBrand;

    @Column(name = "bus_license")
    private String busLicense;

    @Column(name = "bus_year")
    private Integer busYear;

    @Column(name = "bus_lease")
    private Integer busLease;

    @Column(name = "bus_insurance_company")
    private String busInsuranceCompany;

    @Column(name = "bus_insurance_life")
    private Integer busInsuranceLife;

    @Column(name = "bus_in_use")
    private Integer busInUse;


}
