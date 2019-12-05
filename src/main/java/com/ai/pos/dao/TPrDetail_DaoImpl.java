package com.ai.pos.dao;

import com.ai.pos.model.TPrDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TPrDetail_DaoImpl implements TPrDetail_Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPrDetail(TPrDetail tPrDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tPrDetail);
        session.flush();
    }

    @Override
    public void updatePrDetail(TPrDetail tPrDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tPrDetail);
        session.flush();
    }

    @Override
    public void deletePrDetail(TPrDetail tPrDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tPrDetail);
        session.flush();
    }

    @Override
    public void saveOrUpdatePrDetail(TPrDetail tPrDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tPrDetail);
        session.flush();
    }

    @Override
    public TPrDetail findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TPrDetail.class, id);
    }

    @Override
    public List<TPrDetail> listTPrDetailList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TPrDetail.class).list();
    }
}
