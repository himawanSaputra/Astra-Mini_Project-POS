package com.ai.pos.dao;

import com.ai.pos.model.TPo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PurchaseOrderDAO implements DAO<TPo>{

    @Autowired
    private SessionFactory currentSession;

    @Override
    public TPo get(Integer id) {
        Session session = currentSession.getCurrentSession();
        return session.get(TPo.class, id);
    }

    @Override
    public List<TPo> getAll() {
        Session session = currentSession.getCurrentSession();

        return session.createCriteria(TPo.class).list();
    }

    @Override
    public void insert(TPo po) {
        Session session = currentSession.getCurrentSession();
        session.save(po);

    }

    @Override
    public void update(TPo po) {
        Session session = currentSession.getCurrentSession();
        session.update(po);
    }

    @Override
    public void delete(TPo po) {
        Session session = currentSession.getCurrentSession();
        session.delete(po);
    }

    @Override
    public List<TPo> search(String theSearchName) {
        return null;
    }
}
