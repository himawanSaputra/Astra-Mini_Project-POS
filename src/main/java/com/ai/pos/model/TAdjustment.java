package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment")
public class TAdjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
//    @JoinColumn(name="outlet_id", referencedColumnName = "id")
//    private  MstOutlet mstOutlet;

    @Column(name = "notes", nullable = true, length = 255)
    private String notes;

    @Column(name = "status", nullable = false, length = 20)
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
