package com.ai.pos.service;

import com.ai.pos.dao.Employee_Dao;
import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Employee_ServiceImpl implements Employee_Service {

    @Autowired
    Employee_Dao employee_dao;

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
    public void deleteEmployee(MstEmployee mstEmployee) {
        this.employee_dao.deleteEmployee(mstEmployee);
    }

    @Override
    @Transactional
    public MstEmployee getMstEmployeeById(int id) {
        return this.employee_dao.findOne(id);
    }

    @Override
    public MstEmployee getEmloyeeByEmail(String email) {
        return this.employee_dao.getEmployeeByEmail(email);
    }

    @Override
    @Transactional
    public List<MstEmployee> listMstEmployes() {
        return this.employee_dao.listMstEmployes();
    }

}
