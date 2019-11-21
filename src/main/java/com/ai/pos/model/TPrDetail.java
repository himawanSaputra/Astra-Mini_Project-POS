package com.ai.pos.model;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Date;

@Entity
@Table(name = "pos_t_pr_detail")
public class TPrDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(targetEntity = TPr.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "pr_id", referencedColumnName = "id")
//    private TPr tPr;
//
//    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "variant_id", referencedColumnName = "id")
//    private MstItemVariant mstItemVariant;
//
//    @Column(name = "request_qty", nullable = false)
//    private Integer requestQty;
//
//    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name="created_by", referencedColumnName = "id")
//    private MstUser createdBy;

    @Column(name = "created_on", nullable = true)
    private Date createdOn;

//    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name="modified_by", referencedColumnName = "id")
//    private MstUser modifiedBy;

    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public TPr gettPr() {
//        return tPr;
//    }
//
//    public void settPr(TPr tPr) {
//        this.tPr = tPr;
//    }
//
//    public MstItemVariant getMstItemVariant() {
//        return mstItemVariant;
//    }
//
//    public void setMstItemVariant(MstItemVariant mstItemVariant) {
//        this.mstItemVariant = mstItemVariant;
//    }

//    public Integer getRequestQty() {
//        return requestQty;
//    }
//
//    public void setRequestQty(Integer requestQty) {
//        this.requestQty = requestQty;
//    }

//    public MstUser getCreatedBy() {
//        return createdBy;
//    }
//
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
//
//    public void setModifiedBy(MstUser modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

//    @Override
//    public String toString() {
//        return "TPrDetail{" +
//                "id=" + id +
//                ", tPr=" + tPr +
//                ", mstItemVariant=" + mstItemVariant +
//                ", requestQty=" + requestQty +
//                ", createdBy=" + createdBy +
//                ", createdOn=" + createdOn +
//                ", modifiedBy=" + modifiedBy +
//                ", modifiedOn=" + modifiedOn +
//                '}';
//    }
}