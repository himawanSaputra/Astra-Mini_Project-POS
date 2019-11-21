package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_category")
public class MstCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 255)
    private String name;

//    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "created_by", referencedColumnName = "id")
//    private MstUser createdBy;

    @Column(name = "created_on")
    private Date createdOn;

//    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "modified_by", referencedColumnName = "id")
//    private MstUser modifiedBy;

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

//    public MstUser getCreatedBy() {
//        return createdBy;
//    }

//    public void setCreatedBy(MstUser createdBy) {
//        this.createdBy = createdBy;
//    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

//    public MstUser getModifiedBy() {
//        return modifiedBy;
//    }

//    public void setModifiedBy(MstUser modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }

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

//    @Override
//    public String toString() {
//        return "MstCategory{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", createdBy=" + createdBy +
//                ", createdOn=" + createdOn +
//                ", modifiedBy=" + modifiedBy +
//                ", modifiedOn=" + modifiedOn +
//                ", active=" + active +
//                '}';
//    }
}

