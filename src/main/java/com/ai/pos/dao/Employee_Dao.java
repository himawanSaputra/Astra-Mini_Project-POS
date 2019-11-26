package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstUser;

import java.util.List;

public interface Employee_Dao {

    public void addEmployee(MstEmployee mstEmployee);
    public void updateEmployee(MstEmployee mstEmployee);
    public void deleteEmployee(MstEmployee mstEmployee);
    public MstEmployee findOne(int id);
//    public List<MstUser> listMstEmployee();
    public List<MstEmployee> listMstEmployes();
}
