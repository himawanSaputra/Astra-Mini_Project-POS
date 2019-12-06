package com.ai.pos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_province")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MstProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private MstUser createdBy;

    @Column(name = "created_on", nullable = true)
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private MstUser modifiedBy;

    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @JsonIgnore
    @OneToMany( mappedBy = "mstProvince", cascade = CascadeType.ALL)
    private List<MstRegion> mstRegions;

    @JsonIgnore
    @OneToMany(mappedBy = "mstProvince",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<MstSupplier> mstSupplierList;

    public MstProvince() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<MstRegion> getMstRegions() {
        return mstRegions;
    }

    public void setMstRegions(List<MstRegion> mstRegions) {
        this.mstRegions = mstRegions;
    }

    public List<MstSupplier> getMstSupplierList() {
        return mstSupplierList;
    }

    public void setMstSupplierList(List<MstSupplier> mstSupplierList) {
        this.mstSupplierList = mstSupplierList;
    }

    @Override
    public String toString() {
        return "MstProvince{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}