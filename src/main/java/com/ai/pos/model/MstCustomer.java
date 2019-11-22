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
    @JoinColumn(name="province_id", referencedColumnName = "id", nullable = false)
    private MstProvince mstProvince;

    @ManyToOne(targetEntity = MstRegion.class, fetch = FetchType.LAZY)
    @JoinColumn(name="region_id", referencedColumnName = "id", nullable = false)
    private MstRegion mstRegion;

    @ManyToOne(targetEntity = MstDistrict.class, fetch = FetchType.LAZY)
    @JoinColumn(name="district_id", referencedColumnName = "id", nullable = false)
    private MstDistrict mstDistrict;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "MstCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", mstProvince=" + mstProvince +
                ", mstRegion=" + mstRegion +
                ", mstDistrict=" + mstDistrict +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
