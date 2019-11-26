package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Employee_DaoImpl implements Employee_Dao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addEmployee(MstEmployee mstEmployee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(mstEmployee);
        session.flush();
    }

    @Override
    public void updateEmployee(MstEmployee mstEmployee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstEmployee);
        session.flush();
    }

    @Override
    public void deleteEmployee(MstEmployee mstEmployee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstEmployee);
        session.flush();
    }

    @Override
    public MstEmployee findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstEmployee.class, id);
    }

//    @Override
//    public List<MstUser> listMstEmployee() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createCriteria(MstUser.class).list();
//    }

    @Override
    public List<MstEmployee> listMstEmployes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstEmployee.class).list();
    }
}
