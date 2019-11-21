package com.ai.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_t_pr_history")
public class TPrHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(targetEntity = TPr.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "pr_id", referencedColumnName = "id")
//    private TPr tPr;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

//    @ManyToOne(targetEntity = MstUser.class, fetch = FetchType.LAZY)
//    @JoinColumn(name="created_by", referencedColumnName = "id")
//    private MstUser createdBy;

    @Column(name = "created_on", nullable = true)
    private Date createOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public TPr gettPr() {
//        return tPr;
//    }
//
//    public void settPr(TPr tPr) {
//        this.tPr = tPr;
//    }

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

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

//    @Override
//    public String toString() {
//        return "TPrHistory{" +
//                "id=" + id +
//                ", tPr=" + tPr +
//                ", status='" + status + '\'' +
//                ", createdBy=" + createdBy +
//                ", createOn=" + createOn +
//                '}';
//    }
}