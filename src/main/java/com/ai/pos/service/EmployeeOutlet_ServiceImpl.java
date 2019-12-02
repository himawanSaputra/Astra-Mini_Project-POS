package com.ai.pos.service;

import com.ai.pos.dao.EmployeeOutlet_Dao;
import com.ai.pos.model.EmployeeOutlet;
import com.ai.pos.model.MstEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeOutlet_ServiceImpl implements EmployeeOutlet_Service {

    @Autowired
    private EmployeeOutlet_Dao employeeOutlet_dao;

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
    public void deleteEmployee(EmployeeOutlet employeeOutlet) {
        this.employeeOutlet_dao.deleteEmployeeOutlet(employeeOutlet);
    }

    @Override
    @Transactional
    public EmployeeOutlet getEmployeeOutletById(int id) {
        return this.employeeOutlet_dao.findOne(id);
    }

    @Override
    public List<EmployeeOutlet> getEmployeeOutletByEmployeeId(int id) {
        return this.employeeOutlet_dao.getEmployeeOutletByEmployeeId(id);
    }

    @Override
    @Transactional
    public List<EmployeeOutlet> listEmployeeOutlet() {
        return this.employeeOutlet_dao.employeeOutlet();
    }
}
