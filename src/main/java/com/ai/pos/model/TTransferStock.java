package com.ai.pos.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pos_t_transfer_stock")
public class TTransferStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name="from_outlet", referencedColumnName = "id", nullable = false)
    private  MstOutlet fromMstOutlet;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name="to_outlet", referencedColumnName = "id", nullable = false)
    private  MstOutlet toMstOutlet;

    @Column(name = "notes")
    private String notes;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @OneToMany(mappedBy = "transferId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TTransferStockDetail> tTransferStockDetailList = new HashSet<>();

    @OneToMany(mappedBy = "tTransferStock", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TTransferStockHistory> tTransferStockHistoryList = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MstOutlet getFromMstOutlet() {
        return fromMstOutlet;
    }

    public void setFromMstOutlet(MstOutlet fromMstOutlet) {
        this.fromMstOutlet = fromMstOutlet;
    }

    public MstOutlet getToMstOutlet() {
        return toMstOutlet;
    }

    public void setToMstOutlet(MstOutlet toMstOutlet) {
        this.toMstOutlet = toMstOutlet;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Set<TTransferStockDetail> gettTransferStockDetailList() {
        return tTransferStockDetailList;
    }

    public void settTransferStockDetailList(Set<TTransferStockDetail> tTransferStockDetailList) {
        this.tTransferStockDetailList = tTransferStockDetailList;
    }

    public Set<TTransferStockHistory> gettTransferStockHistoryList() {
        return tTransferStockHistoryList;
    }

    public void settTransferStockHistoryList(Set<TTransferStockHistory> tTransferStockHistoryList) {
        this.tTransferStockHistoryList = tTransferStockHistoryList;
    }

    @Override
    public String toString() {
        return "TTransferStock{" +
                "id=" + id +
                ", fromMstOutlet=" + fromMstOutlet +
                ", toMstOutlet=" + toMstOutlet +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
