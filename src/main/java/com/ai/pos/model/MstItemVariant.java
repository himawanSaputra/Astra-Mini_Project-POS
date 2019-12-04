package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pos_mst_item_variant")
public class MstItemVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "mstItemVariant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ItemInventory> itemInventorySet = new HashSet<>();

    @OneToMany(mappedBy = "mstItemVariant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TAdjustmentDetail> tAdjustmentDetails = new HashSet<>();

    @ManyToOne(targetEntity = MstItem.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private MstItem mstItem;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "sku", nullable = false, length = 50)
    private  String sku;

    @Column(name = "price", nullable = false)
    private  Double price;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "active", nullable = false, length = 50)
    private  Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<ItemInventory> getItemInventorySet() {
        return itemInventorySet;
    }

    public void setItemInventorySet(Set<ItemInventory> itemInventorySet) {
        this.itemInventorySet = itemInventorySet;
    }

    public MstItem getMstItem() {
        return mstItem;
    }

    public void setMstItem(MstItem mstItem) {
        this.mstItem = mstItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Set<TAdjustmentDetail> gettAdjustmentDetails() {
        return tAdjustmentDetails;
    }

    public void settAdjustmentDetails(Set<TAdjustmentDetail> tAdjustmentDetails) {
        this.tAdjustmentDetails = tAdjustmentDetails;
    }

    @Override
    public String toString() {
        return "MstItemVariant{" +
                "id=" + id +
//                ", itemInventory=" + itemInventory +
                ", tAdjustmentDetails=" + tAdjustmentDetails +
                ", mstItem=" + mstItem +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", active=" + active +
                '}';
    }
}
