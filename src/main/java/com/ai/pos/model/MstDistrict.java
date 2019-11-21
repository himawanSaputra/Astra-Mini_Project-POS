package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_district")
public class MstDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.LAZY)
    @JoinColumn(name="region_id", referencedColumnName = "id")
    private  MstRegion mstRegion;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

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
