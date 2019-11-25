package com.ai.pos.dao;

import com.ai.pos.model.MstRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Role_DaoImpl implements Role_Dao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addRole(MstRole mstRole) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(mstRole);
    }

    @Override
    public void updateRole(MstRole mstRole) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(mstRole);
    }

    @Override
    public void deleteRole(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MstRole mstRole = (MstRole) session.load(MstRole.class, new Integer(id));
        if(null != mstRole){
            session.delete(mstRole);
        }
    }


    @Override
    public MstRole findOne(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MstRole mstRole = (MstRole) session.load(MstRole.class, new Integer(id));
        return mstRole;
    }

    @Override
    public List<MstRole> listMstRole() {
        Session session = this.sessionFactory.getCurrentSession();
        List<MstRole> mstRoleList = session.createQuery("from Role").list();
        for(MstRole mstRole : mstRoleList){
            LOGGER.info("Role list:"+mstRole);
        }
        return mstRoleList;
    }
}
