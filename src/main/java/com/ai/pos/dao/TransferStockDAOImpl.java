package com.ai.pos.dao;

import com.ai.pos.model.TTransferStock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TransferStockDAOImpl implements TransferStockDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public TTransferStock get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TTransferStock.class, id);
    }

    @Override
    public List<TTransferStock> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TTransferStock> query = cb.createQuery(TTransferStock.class);
        Root<TTransferStock> root = query.from(TTransferStock.class);
        query.select(root);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<TTransferStock> getByFromOutletId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TTransferStock> query = cb.createQuery(TTransferStock.class);
        Root<TTransferStock> root = query.from(TTransferStock.class);
        query.select(root).where(cb.equal(root.get("fromMstOutlet"), id));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public void insert(TTransferStock object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
        session.flush();
    }

    @Override
    public void update(TTransferStock object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
        session.flush();
    }

    @Override
    public void delete(TTransferStock object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
        session.flush();
    }
}
