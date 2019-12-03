package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment_detail")
public class TAdjustmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne(targetEntity = TAdjustment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id", nullable = false)
    private TAdjustment tAdjustment;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", nullable = false)
    private MstItemVariant mstItemVariant;

    @Column(name = "in_stock", nullable = false)
    private Integer inStock;

    @Column(name = "actual_stock", nullable = false)
    private Integer actualStock;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public TAdjustment gettAdjustment() {
        return tAdjustment;
    }

    public void settAdjustment(TAdjustment tAdjustment) {
        this.tAdjustment = tAdjustment;
    }

    public MstItemVariant getMstItemVariant() {
        return mstItemVariant;
    }

    public void setMstItemVariant(MstItemVariant mstItemVariant) {
        this.mstItemVariant = mstItemVariant;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Integer getActualStock() {
        return actualStock;
    }

    public void setActualStock(Integer actualStock) {
        this.actualStock = actualStock;
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
        return "TAdjustmentDetail{" +
                "Id=" + Id +
                ", tAdjustment=" + tAdjustment +
                ", mstItemVariant=" + mstItemVariant +
                ", inStock=" + inStock +
                ", actualStock=" + actualStock +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
