package com.ai.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "pos_employee_outlet")
public class EmployeeOutlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = MstEmployee.class, fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "id", nullable = false)
    private MstEmployee mstEmployee;

    @ManyToOne(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="outlet_id", referencedColumnName = "id", nullable = false)
    private MstOutlet mstOutlet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MstEmployee getMstEmployee() {
        return mstEmployee;
    }

    public void setMstEmployee(MstEmployee mstEmployee) {
        this.mstEmployee = mstEmployee;
    }

    public MstOutlet getMstOutlet() {
        return mstOutlet;
    }

    public void setMstOutlet(MstOutlet mstOutlet) {
        this.mstOutlet = mstOutlet;
    }

    @Override
    public String toString() {
        return "EmployeeOutlet{" +
                "id=" + id +
                ", mstEmployee=" + mstEmployee +
                ", mstOutlet=" + mstOutlet +
                '}';
    }
}
