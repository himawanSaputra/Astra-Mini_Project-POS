package com.ai.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "pos_employee_outlet")
public class EmployeeOutlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToMany(targetEntity = MstEmployee.class, fetch = FetchType.LAZY)
//    @JoinColumn(name="employee_id", referencedColumnName = "id")
//    private MstEmployee mstEmployee;

    @ManyToMany(targetEntity = MstOutlet.class, fetch = FetchType.LAZY)
    @JoinColumn(name="outlet_id", referencedColumnName = "id")
    private MstOutlet mstOutlet;

}
