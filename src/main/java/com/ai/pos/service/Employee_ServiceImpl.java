package com.ai.pos.service;

import com.ai.pos.dao.Employee_Dao;
import com.ai.pos.model.MstEmployee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class Employee_ServiceImpl implements Employee_Service {

    private Employee_Dao employee_dao;
    public void setEmployee_dao(Employee_Dao employee_dao){
        this.employee_dao = employee_dao;
    }

    @Override
    @Transactional
    public void addEmployee(MstEmployee mstEmployee) {
        this.employee_dao.addEmployee(mstEmployee);
    }

    @Override
    @Transactional
    public void updateEmployee(MstEmployee mstEmployee) {
        this.employee_dao.updateEmployee(mstEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employee_dao.deleteEmployee(id);
    }

    @Override
    @Transactional
    public MstEmployee getMstEmployeeById(int id) {
        return this.employee_dao.findOne(id);
    }

    @Override
    @Transactional
    public List<MstEmployee> listMstEmployee() {
        return this.employee_dao.listMstEmployee();
    }
}
