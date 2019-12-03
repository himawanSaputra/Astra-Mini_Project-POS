package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_transfer_stock_history")
public class TTransferStockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TTransferStock.class, fetch = FetchType.EAGER)
    @JoinColumn(name="transfer_id", referencedColumnName = "id", nullable = false)
    private  TTransferStock tTransferStock;

    @Column(name = "status", nullable = false, length = 20)
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

    public TTransferStock gettTransferStock() {
        return tTransferStock;
    }

    public void settTransferStock(TTransferStock tTransferStock) {
        this.tTransferStock = tTransferStock;
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
        return "TTransferStockHistory{" +
                "id=" + id +
                ", tTransferStock=" + tTransferStock +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
