package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(targetEntity = MstRole.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private MstRole mstRole;

    //get data objek
    @OneToOne(targetEntity = MstEmployee.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",nullable = false)
    private MstEmployee mstEmployee;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MstRole getMstRole() {
        return mstRole;
    }

    public void setMstRole(MstRole mstRole) {
        this.mstRole = mstRole;
    }

    public MstEmployee getMstEmployee() {
        return mstEmployee;
    }

    public void setMstEmployee(MstEmployee mstEmployee) {
        this.mstEmployee = mstEmployee;
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
        return "MstUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mstRole=" + mstRole +
                ", mstEmployee=" + mstEmployee +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
