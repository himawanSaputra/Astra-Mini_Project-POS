package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_transfer_stock")
public class TTransferStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="from_outlet", referencedColumnName = "id")
    private  MstOutlet fromMstOutlet;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="to_outlet", referencedColumnName = "id")
    private  MstOutlet toMstOutlet;

    @Column(name = "notes")
    private String notes;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="modifiedBy")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

}
