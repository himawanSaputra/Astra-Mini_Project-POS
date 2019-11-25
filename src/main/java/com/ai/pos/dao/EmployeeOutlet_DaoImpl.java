package com.ai.pos.dao;


import com.ai.pos.model.EmployeeOutlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeOutlet_DaoImpl implements EmployeeOutlet_Dao{
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employeeOutlet);
        session.flush();
    }

    @Override
    public void updateEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employeeOutlet);
        session.flush();
    }

    @Override
    public void deleteEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employeeOutlet);
        session.flush();
    }


    @Override
    public EmployeeOutlet findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(EmployeeOutlet.class, id);
    }

    @Override
    public List<EmployeeOutlet> employeeOutlet() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(EmployeeOutlet.class).list();
    }
}
