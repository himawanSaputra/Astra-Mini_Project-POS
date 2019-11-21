package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_item_inventory")
public class ItemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
    @JoinColumn(name="variant_id", referencedColumnName = "id")
    private  MstItemVariant mstItemVariant;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="outlet_id", referencedColumnName = "id")
    private  MstOutlet mstOutlet;

    @Column(name = "beginning", nullable = false)
    private Integer beginning;

    @Column(name = "purchase_qty")
    private Integer purchaseQty;

    @Column(name = "sales_order_qty")
    private Integer salesOrderQty;

    @Column(name = "adjustment_qty")
    private Integer adjusmtmentQty;

    @Column(name = "ending_qty", nullable = false)
    private Integer endingQty;

    @Column(name = "alert_at_qty", nullable = false)
    private Integer alertAtQty;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
