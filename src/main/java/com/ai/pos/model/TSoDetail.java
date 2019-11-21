package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_so_detail")
public class TSoDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(targetEntity = TSo.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "so_id", referencedColumnName = "id")
//    private TSo tSo;
//
//    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "variant_id", referencedColumnName = "id")
//    private MstItemVariant mstItemVariant;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "sub_total", nullable = true)
    private Double subTotal;

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

//    public TSo gettSo() {
//        return tSo;
//    }

//    public void settSo(TSo tSo) {
//        this.tSo = tSo;
//    }
//
//    public MstItemVariant getMstItemVariant() {
//        return mstItemVariant;
//    }
//
//    public void setMstItemVariant(MstItemVariant mstItemVariant) {
//        this.mstItemVariant = mstItemVariant;
//    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

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
//        return "TSoDetail{" +
//                "id=" + id +
//                ", tSo=" + tSo +
//                ", mstItemVariant=" + mstItemVariant +
//                ", qty=" + qty +
//                ", unitPrice=" + unitPrice +
//                ", subTotal=" + subTotal +
//                ", createdBy=" + createdBy +
//                ", createdOn=" + createdOn +
//                ", modifiedBy=" + modifiedBy +
//                ", modifiedOn=" + modifiedOn +
//                '}';
//    }
}