package com.ai.pos.dao;

import com.ai.pos.model.MstRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Role_DaoImpl implements Role_Dao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addRole(MstRole mstRole) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(mstRole);
        session.flush();
    }

    @Override
    public void updateRole(MstRole mstRole) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstRole);
        session.flush();
    }

    @Override
    public void deleteRole(MstRole mstRole) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstRole);
        session.flush();
    }


    @Override
    public MstRole findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstRole.class, id);
    }

    @Override
    public List<MstRole> listMstRole() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstRole.class).list();
    }
}
