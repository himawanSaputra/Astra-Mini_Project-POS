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

    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name="created_by", referencedColumnName = "id")
    private MstUser createdBy;

    @Column(name = "created_on", nullable = true)
    private Date createdOn;

    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by", referencedColumnName = "id")
    private MstUser modifiedBy;

    @Column(name = "modified_on", nullable = true)
    private Date modifiedOn;
}
