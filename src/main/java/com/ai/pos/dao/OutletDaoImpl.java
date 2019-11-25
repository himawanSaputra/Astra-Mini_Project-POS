package com.ai.pos.dao;

import com.ai.pos.model.MstOutlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OutletDaoImpl implements OutletDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addOutlet(MstOutlet mstOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstOutlet);
        session.flush();
    }

    @Override
    public void updateOutlet(MstOutlet mstOutlet) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstOutlet);
        session.flush();
    }

    @Override
    public void deleteOutlet(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(listMstOutlet());
        session.flush();
    }

    @Override
    public MstOutlet findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(MstOutlet.class, id);
    }

    @Override
    public List<MstOutlet> listMstOutlet() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstOutlet.class).list();
    }
}
