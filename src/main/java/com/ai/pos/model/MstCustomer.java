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

    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.LAZY)
    @JoinColumn(name="province_id", referencedColumnName = "id")
    private MstProvince mstProvince;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.LAZY)
    @JoinColumn(name="region_id", referencedColumnName = "id")
    private MstRegion mstRegion;

    @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.LAZY)
    @JoinColumn(name="district_id", referencedColumnName = "id")
    private MstDistrict mstDistrict;

    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name="created_by", referencedColumnName = "id")
    private MstUser createdBy;

    @Column(name = "created_on", nullable = true)
    private Date createdOn;

    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by", referencedColumnName = "id")
    private MstUser modifiedBy;

    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
