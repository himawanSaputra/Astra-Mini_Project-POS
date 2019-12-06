package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_po")
public class TPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TPr.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pr_id", referencedColumnName = "id", nullable = false)
    private TPr tPr;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "outlet_id", referencedColumnName = "id", nullable = false)
    private MstOutlet mstOutlet;

    @ManyToOne(targetEntity = MstSupplier.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", nullable = false)
    private MstSupplier mstSupplier;

    @Column(name = "po_no", length = 20, nullable = false)
    private String poNo;

    @Column(name = "notes", length = 255)
    private String notes;

    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

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

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }

    public MstSupplier getMstSupplier() {
        return mstSupplier;
    }

    public void setMstSupplier(MstSupplier mstSupplier) {
        this.mstSupplier = mstSupplier;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
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
        return "TPo{" +
                "id=" + id +
                ", tPr=" + tPr +
                ", mstOutlet=" + mstOutlet +
                ", mstSupplier=" + mstSupplier +
                ", poNo='" + poNo + '\'' +
                ", notes='" + notes + '\'' +
                ", grandTotal=" + grandTotal +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
