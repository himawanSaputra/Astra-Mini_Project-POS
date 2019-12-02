package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_user")
public class MstUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

//    @ManyToOne(targetEntity = MstRole.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstRole roleId;
//
//    @ManyToOne(targetEntity = MstEmployee.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstEmployee employeeId;

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

    @OneToMany( mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<MstSupplier> mstSupplierCreatedList;

    @OneToMany( mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<MstProvince> mstProvinceCreatedList;

    @OneToMany( mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<MstRegion> mstRegionCreatedList;

    @OneToMany( mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<MstDistrict> mstDistrictCreatedList;

    @OneToMany( mappedBy = "modifiedBy", cascade = CascadeType.ALL)
    private List<MstSupplier> mstSupplierModifiedList;

    @OneToMany( mappedBy = "modifiedBy", cascade = CascadeType.ALL)
    private List<MstProvince> mstProvinceModifiedList;

    @OneToMany( mappedBy = "modifiedBy", cascade = CascadeType.ALL)
    private List<MstRegion> mstRegionModifiedList;

    @OneToMany( mappedBy = "modifiedBy", cascade = CascadeType.ALL)
    private List<MstDistrict> mstDistrictModifiedList;
}
