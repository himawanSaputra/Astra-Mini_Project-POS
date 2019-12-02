package com.ai.pos.service;

import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstUser;

import java.util.List;

public interface Employee_Service {

    public void addEmployee(MstEmployee mstEmployee);
    public void updateEmployee(MstEmployee mstEmployee);
    public void deleteEmployee(MstEmployee mstEmployee);
    public MstEmployee getMstEmployeeById(int id);
    public List<MstEmployee> listMstEmployes();
}
