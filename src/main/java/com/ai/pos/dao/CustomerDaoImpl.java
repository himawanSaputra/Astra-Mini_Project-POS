package com.ai.pos.dao;

import com.ai.pos.model.MstCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(MstCustomer mstCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstCustomer);
        session.flush();
    }

    @Override
    public void updateCustomer(MstCustomer mstCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstCustomer);
        session.flush();
    }

    @Override
    public void deleteCustomer(MstCustomer mstCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstCustomer);
        session.flush();
    }

    @Override
    public MstCustomer findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(MstCustomer.class, id);
    }

    @Override
    public List<MstCustomer> listMstCustomer() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstCustomer.class).list();
    }
}
