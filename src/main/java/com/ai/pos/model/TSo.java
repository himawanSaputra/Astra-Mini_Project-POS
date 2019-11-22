package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_so")
public class TSo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = MstCustomer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MstCustomer customerId;

    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

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

    public MstCustomer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(MstCustomer customerId) {
        this.customerId = customerId;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
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
        return "TSo{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", grandTotal=" + grandTotal +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
