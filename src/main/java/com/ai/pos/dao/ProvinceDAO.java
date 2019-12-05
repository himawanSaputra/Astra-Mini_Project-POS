package com.ai.pos.dao;

import com.ai.pos.model.MstProvince;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceDAO implements DAO<MstProvince> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public MstProvince get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        MstProvince theProvince = session.get(MstProvince.class, id);
        return theProvince;
    }

    @Override
    public List<MstProvince> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstProvince.class).list();
    }

    @Override
    public void insert(MstProvince object) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(object);
    }

    @Override
    public void update(MstProvince object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);

    }

    @Override
    public void delete(MstProvince object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

    @Override
    public List<MstProvince> search(String theSearchName) {
        return null;
    }
}
