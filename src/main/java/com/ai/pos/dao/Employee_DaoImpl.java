package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Employee_DaoImpl implements Employee_Dao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

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

    @Override
    public List<MstEmployee> listMstEmployee() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstEmployee.class).list();
    }
}
