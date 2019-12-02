package com.ai.pos.dao;

import com.ai.pos.model.MstCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MstCategoryDaoImpl implements MstCategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(MstCategory mstCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mstCategory);
        session.flush();
    }

    @Override
    public void update(MstCategory mstCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstCategory);
        session.flush();
    }

    @Override
    public void delete(MstCategory mstCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstCategory);
        session.flush();
    }

    @Override
    public MstCategory getCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstCategory.class, id);
    }

    @Override
    public List<MstCategory> getAllCategory() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstCategory.class).list();
    }
}
