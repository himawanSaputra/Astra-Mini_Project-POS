package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Employee_DaoImpl implements Employee_Dao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addEmployee(MstEmployee mstEmployee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(mstEmployee);
    }

    @Override
    public void updateEmployee(MstEmployee mstEmployee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(mstEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MstEmployee mstEmployee = (MstEmployee) session.load(MstEmployee.class, new Integer(id));
        if(null != mstEmployee){
            session.delete(mstEmployee);
        }
    }


    @Override
    public MstEmployee findOne(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MstEmployee mstEmployee = (MstEmployee) session.load(MstEmployee.class, new Integer(id));
        return mstEmployee;
    }

    @Override
    public List<MstEmployee> listMstEmployee() {
        Session session = this.sessionFactory.getCurrentSession();
        List<MstEmployee> employeeList = session.createQuery("from Employee").list();
        for(MstEmployee mstEmployee : employeeList){
            LOGGER.info("Person List::"+mstEmployee);
        }
        return listMstEmployee();
    }
}
