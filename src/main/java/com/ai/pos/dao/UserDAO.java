package com.ai.pos.dao;

import com.ai.pos.model.MstUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAO implements DAO<MstUser>{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public MstUser get(Integer id) {
        return null;
    }

    public MstUser getByUsernamePassword(String username, String password){
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstUser> query = cb.createQuery(MstUser.class);
        Root<MstUser> root = query.from(MstUser.class);
        query.select(root)
                .where(cb.equal(root.get("username"), username))
                .where(cb.equal(root.get("password"), password));
        Query q = session.createQuery(query);
        return (MstUser) q.getSingleResult();
    }

    @Override
    public List<MstUser> getAll() {
        return null;
    }

    @Override
    public void insert(MstUser object) {

    }

    @Override
    public void update(MstUser object) {

    }

    @Override
    public void delete(MstUser object) {

    }
}
