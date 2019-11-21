package com.ai.pos.dao;

import com.ai.pos.model.MstSupplier;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDAO implements DAO<MstSupplier> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public MstSupplier get(Integer id) {

        return null;
    }

    @Override
    public List<MstSupplier> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<MstSupplier> suppliers = session.createSQLQuery("select * from pos_mst_supplier").list();
        return suppliers;
    }

    @Override
    public void insert(MstSupplier object) {

    }

    @Override
    public void update(MstSupplier object) {

    }

    @Override
    public void delete(MstSupplier object) {

    }
}
