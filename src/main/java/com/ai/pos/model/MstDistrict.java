package com.ai.pos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_district")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MstDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "region_id")
    private  MstRegion mstRegion;

    @Column(name = "name", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name="created_by")
    private MstUser createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name="modified_by")
    private MstUser modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "active")
    private Boolean active;

    @JsonIgnore
    @OneToMany( mappedBy = "mstRegion",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<MstSupplier> mstSupplierList;

    public MstDistrict() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MstRegion getMstRegion() {
        return mstRegion;
    }

    public void setMstRegion(MstRegion mstRegion) {
        this.mstRegion = mstRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MstUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(MstUser createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public MstUser getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(MstUser modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<MstSupplier> getMstSupplierList() {
        return mstSupplierList;
    }

    public void setMstSupplierList(List<MstSupplier> mstSupplierList) {
        this.mstSupplierList = mstSupplierList;
    }

    @Override
    public String toString() {
        return "MstDistrict{" +
                "id=" + id +
                ", mstRegion=" + mstRegion +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
