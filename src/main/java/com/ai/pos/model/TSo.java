package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_so")
public class TSo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(targetEntity = MstCustomer.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private MstCustomer customerId;

    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
