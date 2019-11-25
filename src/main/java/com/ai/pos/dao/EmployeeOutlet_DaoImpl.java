package com.ai.pos.dao;


import com.ai.pos.model.EmployeeOutlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class EmployeeOutlet_DaoImpl implements EmployeeOutlet_Dao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employeeOutlet);
    }

    @Override
    public void updateEmployeeOutlet(EmployeeOutlet employeeOutlet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employeeOutlet);
    }

    @Override
    public void deleteEmployeeOutlet(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        EmployeeOutlet employeeOutlet = (EmployeeOutlet) session.load(EmployeeOutlet.class, new Integer(id));
        if(null != employeeOutlet){
            session.delete(employeeOutlet);
        }
    }


    @Override
    public EmployeeOutlet findOne(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        EmployeeOutlet employeeOutlet = (EmployeeOutlet) session.load(EmployeeOutlet.class, new Integer(id));
        return employeeOutlet;
    }

    @Override
    public List<EmployeeOutlet> employeeOutlet() {
        Session session = this.sessionFactory.getCurrentSession();
        List<EmployeeOutlet> employeeOutletList = session.createQuery("from Employee outlet").list();
        for(EmployeeOutlet employeeOutlet : employeeOutletList){
            LOGGER.info("Employee outlet List::"+employeeOutlet);
        }
        return employeeOutletList;
    }
}
