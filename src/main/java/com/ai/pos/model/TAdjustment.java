package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment")
public class TAdjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="outlet_id", referencedColumnName = "id")
    private  MstOutlet mstOutlet;

    @Column(name = "notes", nullable = true, length = 255)
    private String notes;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

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
