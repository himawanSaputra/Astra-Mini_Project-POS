package com.ai.pos.service;

import com.ai.pos.dao.EmployeeOutlet_Dao;
import com.ai.pos.model.EmployeeOutlet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeOutlet_ServiceImpl implements EmployeeOutlet_Service {

    private EmployeeOutlet_Dao employeeOutlet_dao;

    public void setEmployeeOutlet_dao(EmployeeOutlet_Dao employeeOutlet_dao) {
        this.employeeOutlet_dao = employeeOutlet_dao;
    }

    @Override
    @Transactional
    public void addEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        this.employeeOutlet_dao.addEmployeeOutlet(employeeOutlet);
    }

    @Override
    @Transactional
    public void updateEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        this.employeeOutlet_dao.updateEmployeeOutlet(employeeOutlet);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employeeOutlet_dao.deleteEmployeeOutlet(id);
    }

    @Override
    @Transactional
    public EmployeeOutlet getEmployeeOutletById(int id) {
        return this.employeeOutlet_dao.findOne(id);
    }

    @Override
    @Transactional
    public List<EmployeeOutlet> listEmployeeOutlet() {
        return this.employeeOutlet_dao.listEmployeeOutlet();
    }
}
