package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_customer")
public class MstCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

//    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.LAZY)
//    @JoinColumn(name="province_id", referencedColumnName = "id")
//    private MstProvince mstProvince;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.LAZY)
    @JoinColumn(name="region_id", referencedColumnName = "id")
    private MstRegion mstRegion;

    @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.LAZY)
    @JoinColumn(name="district_id", referencedColumnName = "id")
    private MstDistrict mstDistrict;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
