package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_item_inventory")
public class ItemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.EAGER)
    @JoinColumn(name="variant_id", referencedColumnName = "id")
    private  MstItemVariant mstItemVariant;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="outlet_id", referencedColumnName = "id", nullable = false)
    private  MstOutlet mstOutlet;

    @Column(name = "beginning", nullable = false)
    private Integer beginning;

    @Column(name = "purchase_qty")
    private Integer purchaseQty;

    @Column(name = "sales_order_qty")
    private Integer salesOrderQty;

    @Column(name = "transfer_stock_qty")
    private Integer transferStockQty;

    @Column(name = "adjustment_qty")
    private Integer adjustmentQty;

    @Column(name = "ending_qty", nullable = false)
    private Integer endingQty;

    @Column(name = "alert_at_qty", nullable = false)
    private Integer alertAtQty;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MstItemVariant getMstItemVariant() {
        return mstItemVariant;
    }

    public void setMstItemVariant(MstItemVariant mstItemVariant) {
        this.mstItemVariant = mstItemVariant;
    }

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }

    public Integer getBeginning() {
        return beginning;
    }

    public void setBeginning(Integer beginning) {
        this.beginning = beginning;
    }

    public Integer getPurchaseQty() {
        return purchaseQty;
    }

    public void setPurchaseQty(Integer purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    public Integer getSalesOrderQty() {
        return salesOrderQty;
    }

    public void setSalesOrderQty(Integer salesOrderQty) {
        this.salesOrderQty = salesOrderQty;
    }

    public Integer getTransferStockQty() {
        return transferStockQty;
    }

    public void setTransferStockQty(Integer transferStockQty) {
        this.transferStockQty = transferStockQty;
    }

    public Integer getAdjustmentQty() {
        return adjustmentQty;
    }

    public void setAdjustmentQty(Integer adjustmentQty) {
        this.adjustmentQty = adjustmentQty;
    }

    public Integer getEndingQty() {
        return endingQty;
    }

    public void setEndingQty(Integer endingQty) {
        this.endingQty = endingQty;
    }

    public Integer getAlertAtQty() {
        return alertAtQty;
    }

    public void setAlertAtQty(Integer alertAtQty) {
        this.alertAtQty = alertAtQty;
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
        return "ItemInventory{" +
                "id=" + id +
                ", mstItemVariant=" + mstItemVariant +
                ", mstOutlet=" + mstOutlet +
                ", beginning=" + beginning +
                ", purchaseQty=" + purchaseQty +
                ", salesOrderQty=" + salesOrderQty +
                ", transferStockQty=" + transferStockQty +
                ", adjustmentQty=" + adjustmentQty +
                ", endingQty=" + endingQty +
                ", alertAtQty=" + alertAtQty +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
