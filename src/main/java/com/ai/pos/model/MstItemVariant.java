package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_item_variant")
public class MstItemVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstItem.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private MstItem mstItem;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "sku", nullable = false, length = 50)
    private  String sku;

    @Column(name = "price", nullable = false)
    private  Double price;

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

    @Column(name = "active", nullable = false, length = 50)
    private  Boolean active;
}
