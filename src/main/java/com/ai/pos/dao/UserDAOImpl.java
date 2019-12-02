package com.ai.pos.dao;

import com.ai.pos.model.MstUser;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public MstUser get(Integer id) {
        return null;
    }

    @Override
    public MstUser getByUsernamePassword(String username, String password){
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstUser> query = cb.createQuery(MstUser.class);
        Root<MstUser> root = query.from(MstUser.class);
        query.select(root)
                .where(cb.equal(root.get("username"), username))
                .where(cb.equal(root.get("password"), password));
        Query q = session.createQuery(query);
        List<MstUser> user = q.getResultList();
        if(user.isEmpty()){
            return null;
        }
        return (MstUser) q.getSingleResult();
    }

    @Override
    public MstUser getByEmployeeId(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstUser> query = cb.createQuery(MstUser.class);
        Root<MstUser> root = query.from(MstUser.class);
        query.select(root)
                .where(cb.equal(root.get("mstEmployee"), id));
        Query q = session.createQuery(query);
        List<MstUser> user = q.getResultList();
        if(user.isEmpty()){
            return null;
        }
        return (MstUser) q.getSingleResult();
    }

    @Override
    public List<MstUser> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstUser> query = cb.createQuery(MstUser.class);
        Root<MstUser> root = query.from(MstUser.class);
        query.select(root);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public void insert(MstUser object) {
        Session session = sessionFactory.getCurrentSession();
        session.save(object);
        session.flush();
    }

    @Override
    public void update(MstUser object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
        session.flush();
    }

    @Override
    public void delete(MstUser object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
        session.flush();
    }
}
