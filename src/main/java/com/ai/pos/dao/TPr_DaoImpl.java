package com.ai.pos.dao;

import com.ai.pos.model.TPr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TPr_DaoImpl implements TPr_Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPr(TPr tPr) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tPr);
        session.flush();
    }

    @Override
    public void updatePr(TPr tPr) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tPr);
        session.flush();
    }

    @Override
    public void deletePr(TPr tPr) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tPr);
        session.flush();
    }

    @Override
    public void saveOrUpdatePr(TPr tPr) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tPr);
        session.flush();
    }

    @Override
    public TPr findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TPr.class, id);
    }

    @Override
    public List<TPr> listTPrList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TPr.class).list();
    }
}
