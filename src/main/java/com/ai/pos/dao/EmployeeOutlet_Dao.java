package com.ai.pos.dao;

import com.ai.pos.model.EmployeeOutlet;

import java.util.List;

public interface EmployeeOutlet_Dao {

    public void addEmployeeOutlet(EmployeeOutlet employeeOutlet);
    public void updateEmployeeOutlet(EmployeeOutlet employeeOutlet);
    public void deleteEmployeeOutlet(int id);
    public EmployeeOutlet findOne(int id);
    public List<EmployeeOutlet> employeeOutlet();
}
