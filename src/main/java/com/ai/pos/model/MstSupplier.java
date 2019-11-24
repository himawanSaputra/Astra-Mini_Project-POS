package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_supplier")
public class MstSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 50, nullable = true)
    private String name;

    @Column(name = "address", length = 255, nullable = true)
    private String address;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "email", nullable = true)
    private String email;

    @ManyToOne(targetEntity = MstProvince.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", referencedColumnName = "id", nullable = false)
    private MstProvince mstProvince;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    private MstRegion mstRegion;

    @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)

    private MstDistrict mstDistrict;

    @Column(name = "postal_code", length = 50, nullable = true)
    private String postalCode;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "active", nullable = true)
    private Boolean active;

    public MstSupplier() {
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

    public MstProvince getMstProvince() {
        return mstProvince;
    }

    public void setMstProvince(MstProvince mstProvince) {
        this.mstProvince = mstProvince;
    }

    public MstRegion getMstRegion() {
        return mstRegion;
    }

    public void setMstRegion(MstRegion mstRegion) {
        this.mstRegion = mstRegion;
    }

    public MstDistrict getMstDistrict() {
        return mstDistrict;
    }

    public void setMstDistrict(MstDistrict mstDistrict) {
        this.mstDistrict = mstDistrict;
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
        return "MstSupplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", mstProvince=" + mstProvince +
                ", mstRegion=" + mstRegion +
                ", mstDistrict=" + mstDistrict +
                ", postalCode='" + postalCode + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }

}