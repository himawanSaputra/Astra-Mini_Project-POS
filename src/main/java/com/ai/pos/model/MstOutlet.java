package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_outlet")
public class MstOutlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

//    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "province_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstProvince provinceId;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstRegion regionId;

//    @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "district_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstDistrict districtId;

    @Column(name = "postal_code", length = 6)
    private String postalCode;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
