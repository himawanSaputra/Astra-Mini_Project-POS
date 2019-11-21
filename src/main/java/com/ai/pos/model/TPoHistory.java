package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_po_history")
public class TPoHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = TPo.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "po_id", referencedColumnName = "id")
    private TPo tPo;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

//    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "created_by", referencedColumnName = "id")
//    private MstUser createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TPo gettPo() {
        return tPo;
    }

    public void settPo(TPo tPo) {
        this.tPo = tPo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public MstUser getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(MstUser createdBy) {
//        this.createdBy = createdBy;
//    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

//    @Override
//    public String toString() {
//        return "TPoHistory{" +
//                "id=" + id +
//                ", tPo=" + tPo +
//                ", status='" + status + '\'' +
//                ", createdBy=" + createdBy +
//                ", createdOn=" + createdOn +
//                '}';
//    }
}
