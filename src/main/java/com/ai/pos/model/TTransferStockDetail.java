package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_transfer_stock_detail")
public class TTransferStockDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(targetEntity = TTransferStock.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "transfer_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private TTransferStock transferId;

    @Column(name = "instock")
    private int instock;

//    @OneToMany(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "variant_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstItemVariant variantId;

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
}
