package com.ai.pos.model;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    @ManyToOne
    @JoinColumn(name = "province_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MstProvince mstProvince;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MstRegion mstRegion;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MstDistrict mstDistrict;

    @Column(name = "postal_code", length = 50, nullable = true)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name="created_by")
    private MstUser createdBy;

    @Column(name = "created_on", nullable = true)
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name="modified_by")
    private MstUser modifiedBy;

    @Column(name = "modified_on", nullable = true)
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
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}