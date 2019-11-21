package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_region")
public class MstRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "province_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstProvince provinceId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

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
