package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_po_detail")
public class TPoDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TPo.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "po_id", referencedColumnName = "id")
    private TPo tPo;

    @ManyToOne(targetEntity = MstItemVariant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id")
    private MstItemVariant mstItemVariant;

    @Column(name = "request_qty", nullable = false)
    private Integer requestQty;

    @Column(name = "unit_cost")
    private Double unitCost;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
