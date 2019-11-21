package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment_detail")
public class TAdjustmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne(targetEntity = TAdjustment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id")
    private TAdjustment tAdjustment;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id")
    private MstItemVariant mstItemVariant;

    @Column(name = "in_stock", nullable = false)
    private Integer inStock;

    @Column(name = "actual_stock", nullable = false)
    private Integer actualStock;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
