package com.ai.pos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pos_mst_region")
@JsonInclude(JsonInclude.Include.NON_NULL)
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class MstRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "province_id")
    private MstProvince mstProvince;

    @Column(name = "name", length = 50, nullable = false)
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

    @Column(name = "active", nullable = false)
    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "mstRegion",cascade = CascadeType.ALL)
    private List<MstDistrict> mstDistrictList;

    @JsonIgnore
    @OneToMany( mappedBy = "mstRegion",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<MstSupplier> mstSupplierList;

    public MstRegion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MstProvince getMstProvince() {
        return mstProvince;
    }

    public void setMstProvince(MstProvince mstProvince) {
        this.mstProvince = mstProvince;
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

    public List<MstDistrict> getMstDistrictList() {
        return mstDistrictList;
    }

    public void setMstDistrictList(List<MstDistrict> mstDistrictList) {
        this.mstDistrictList = mstDistrictList;
    }

    public List<MstSupplier> getMstSupplierList() {
        return mstSupplierList;
    }

    public void setMstSupplierList(List<MstSupplier> mstSupplierList) {
        this.mstSupplierList = mstSupplierList;
    }

    @Override
    public String toString() {
        return "MstRegion{" +
                "id=" + id +
                ", mstProvince=" + mstProvince +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
