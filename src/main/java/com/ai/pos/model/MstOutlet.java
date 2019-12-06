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

    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id", referencedColumnName = "id", nullable = false)
    private MstProvince provinceId;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    private MstRegion regionId;

    @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    private MstDistrict districtId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MstProvince getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(MstProvince provinceId) {
        this.provinceId = provinceId;
    }

    public MstRegion getRegionId() {
        return regionId;
    }

    public void setRegionId(MstRegion regionId) {
        this.regionId = regionId;
    }

    public MstDistrict getDistrictId() {
        return districtId;
    }

    public void setDistrictId(MstDistrict districtId) {
        this.districtId = districtId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
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

    @Override
    public String toString() {
        return "MstOutlet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", provinceId=" + provinceId +
                ", regionId=" + regionId +
                ", districtId=" + districtId +
                ", postalCode='" + postalCode + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
