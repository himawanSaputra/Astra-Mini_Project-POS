package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_adjustment_history")
public class TAdjustmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TAdjustment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id")
    private TAdjustment tAdjustment;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name="created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;
}
