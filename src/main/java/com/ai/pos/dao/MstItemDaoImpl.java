package com.ai.pos.dao;

import com.ai.pos.model.MstItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public List<MstItem> getByItemVariantName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstItem> query = cb.createQuery(MstItem.class);
        Root<MstItem> root = query.from(MstItem.class);
        query.select(root)
                .where(cb.like(root.get("name"), "%" + name + "%"));
        Query q = session.createQuery(query);
        List<MstItem> items = q.getResultList();
        return items;
    }
}