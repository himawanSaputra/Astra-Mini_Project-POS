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

    @ManyToOne(targetEntity = TPr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pr_id", referencedColumnName = "id", nullable = false)
    private TPr tPr;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", nullable = false)
    private MstItemVariant mstItemVariant;

    @Column(name = "request_qty", nullable = false)
    private Integer requestQty;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TPr gettPr() {
        return tPr;
    }

    public void settPr(TPr tPr) {
        this.tPr = tPr;
    }

    public MstItemVariant getMstItemVariant() {
        return mstItemVariant;
    }

    public void setMstItemVariant(MstItemVariant mstItemVariant) {
        this.mstItemVariant = mstItemVariant;
    }

    public Integer getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(Integer requestQty) {
        this.requestQty = requestQty;
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

    @Override
    public String toString() {
        return "TPrDetail{" +
                "id=" + id +
                ", tPr=" + tPr +
                ", mstItemVariant=" + mstItemVariant +
                ", requestQty=" + requestQty +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}