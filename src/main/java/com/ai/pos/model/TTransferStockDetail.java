package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_transfer_stock_detail")
public class TTransferStockDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = TTransferStock.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "transfer_id", referencedColumnName = "id", nullable = false)
    private TTransferStock transferId;

    @Column(name = "instock")
    private int instock;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", nullable = false)
    private MstItemVariant variantId;

    @Column(name = "transfer_qty", nullable = false)
    private int transferQty;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TTransferStock getTransferId() {
        return transferId;
    }

    public void setTransferId(TTransferStock transferId) {
        this.transferId = transferId;
    }

    public int getInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public MstItemVariant getVariantId() {
        return variantId;
    }

    public void setVariantId(MstItemVariant variantId) {
        this.variantId = variantId;
    }

    public int getTransferQty() {
        return transferQty;
    }

    public void setTransferQty(int transferQty) {
        this.transferQty = transferQty;
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
        return "TTransferStockDetail{" +
                "id=" + id +
                ", transferId=" + transferId +
                ", instock=" + instock +
                ", variantId=" + variantId +
                ", transferQty=" + transferQty +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
