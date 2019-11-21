package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_transfer_stock_history")
public class TTransferStockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TTransferStock.class, fetch = FetchType.LAZY)
    @JoinColumn(name="transfer_id", referencedColumnName = "id")
    private  TTransferStock tTransferStock;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;
}
