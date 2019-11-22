package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment")
public class TAdjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="outlet_id", referencedColumnName = "id", nullable = false)
    private  MstOutlet mstOutlet;

    @Column(name = "notes", nullable = true, length = 255)
    private String notes;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

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

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
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

    @Override
    public String toString() {
        return "TAdjustment{" +
                "id=" + id +
                ", mstOutlet=" + mstOutlet +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
