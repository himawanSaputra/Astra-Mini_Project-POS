package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import org.hibernate.SessionFactory;

import java.util.List;

public class Employee_DaoImpl implements Employee_Dao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addEmployee(MstEmployee mstEmployee) {

    }

    @Override
    public void updateEmployee(MstEmployee mstEmployee) {

    }

    @Override
    public void deleteEmployee(MstEmployee mstEmployee) {

    }

    @Override
    public MstEmployee findOne(int id) {
        return null;
    }

    @Override
    public List<MstEmployee> listMstEmployee() {
        return null;
    }
}
