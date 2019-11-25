package com.ai.pos.service;

import com.ai.pos.model.EmployeeOutlet;

import java.util.List;

public interface EmployeeOutlet_Service {

    public void addEmployeeOutlet(EmployeeOutlet employeeOutlet);
    public void updateEmployeeOutlet(EmployeeOutlet employeeOutlet);
    public void deleteEmployee(int id);
    public EmployeeOutlet getEmployeeOutletById(int id);
    public List<EmployeeOutlet> listEmployeeOutlet();
}
