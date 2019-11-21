package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_transfer_stock")
public class TTransferStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="from_outlet", referencedColumnName = "id")
    private  MstOutlet fromMstOutlet;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="to_outlet", referencedColumnName = "id")
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
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private String modifiedOn;

    public TTransferStock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MstOutlet getFromOutlet() {
        return fromOutlet;
    }

    public void setFromOutlet(MstOutlet fromOutlet) {
        this.fromOutlet = fromOutlet;
    }

    public MstOutlet getToOutlet() {
        return toOutlet;
    }

    public void setToOutlet(MstOutlet toOutlet) {
        this.toOutlet = toOutlet;
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

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
