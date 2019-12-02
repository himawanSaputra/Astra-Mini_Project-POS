package com.ai.pos.dao;

import com.ai.pos.model.EmployeeOutlet;

import java.util.List;

public interface EmployeeOutlet_Dao {

    public void addEmployeeOutlet(EmployeeOutlet employeeOutlet);
    public void updateEmployeeOutlet(EmployeeOutlet employeeOutlet);
    public void deleteEmployeeOutlet(EmployeeOutlet employeeOutlet);

    public EmployeeOutlet findOne(int id);
    public List<EmployeeOutlet> getByEmployeeId(int id);
    public List<EmployeeOutlet> getEmployeeOutletByEmployeeId(int id);
    public List<EmployeeOutlet> employeeOutlet();
}
