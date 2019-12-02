package com.ai.pos.dao;

import com.ai.pos.model.MstItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MstItemDaoImpl implements MstItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(MstItem mstItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstItem);
        session.flush();
    }

    @Override
    public void update(MstItem mstItem) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstItem);
        session.flush();
    }

    @Override
    public void delete(MstItem mstItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstItem);
        session.flush();
    }

    @Override
    public MstItem getItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstItem.class, id);
    }

    @Override
    public List<MstItem> getAllItem() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstItem.class).list();
    }
}
