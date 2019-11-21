package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_mst_item_variant")
public class MstItemVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(targetEntity = MstItem.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_id", referencedColumnName = "id")
//    private MstItem mstItem;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "sku", nullable = false, length = 50)
    private  String sku;

    @Column(name = "price", nullable = false)
    private  Double price;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "active", nullable = false, length = 50)
    private  Boolean active;
}
