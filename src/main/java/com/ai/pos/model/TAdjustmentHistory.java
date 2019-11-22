package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment_history")
public class TAdjustmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TAdjustment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id", nullable = false)
    private TAdjustment tAdjustment;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TAdjustment gettAdjustment() {
        return tAdjustment;
    }

    public void settAdjustment(TAdjustment tAdjustment) {
        this.tAdjustment = tAdjustment;
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

    @Override
    public String toString() {
        return "TAdjustmentHistory{" +
                "id=" + id +
                ", tAdjustment=" + tAdjustment +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
