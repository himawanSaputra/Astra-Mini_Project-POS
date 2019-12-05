package com.ai.pos.dao;

import com.ai.pos.model.MstItemVariant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MstItemVariantDaoImpl implements MstItemVariantDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(MstItemVariant mstItemVariant) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstItemVariant);
        session.flush();
    }

    @Override
    public void update(MstItemVariant mstItemVariant) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstItemVariant);
        session.flush();
    }

    @Override
    public void delete(MstItemVariant mstItemVariant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstItemVariant);
        session.flush();
    }

    @Override
    public MstItemVariant getItemVariant(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstItemVariant.class, id);
    }

    @Override
    public List<MstItemVariant> getAllItemVariant() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstItemVariant.class).list();
    }
}
