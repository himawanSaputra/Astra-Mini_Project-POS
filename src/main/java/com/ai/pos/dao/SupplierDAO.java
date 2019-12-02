package com.ai.pos.dao;

import com.ai.pos.model.MstSupplier;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SupplierDAO implements DAO<MstSupplier> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public MstSupplier get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
//        MstSupplier theSupplier = session.get(MstSupplier.class, id);
//        return theSupplier;
        try {

//            MstSupplier theSupplier = session.get(MstSupplier.class, id);
            Query<MstSupplier> theQuery = null;
            if (id != null) {
                theQuery = session.createSQLQuery("SELECT * FROM pos_mst_supplier msup " +
                        "left join pos_mst_province mpro on (msup.province_id = mpro.id) " +
                        "left join pos_mst_district mdis on (msup.district_id = mdis.id) " +
                        "left join pos_mst_region mreg on (msup.region_id = mreg.id) " +
                        "where msup.id =  :theId").addEntity(MstSupplier.class);
                theQuery.setParameter("theId", id);
            }
            MstSupplier theSupplier = theQuery.getSingleResult();
            return theSupplier;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<MstSupplier> getAll() {
        Session session = sessionFactory.getCurrentSession();
//        List<MstSupplier> suppliers = session.createCriteria(MstSupplier.class).list();
        List<MstSupplier> suppliers = session.createSQLQuery("SELECT * FROM pos_mst_supplier msup  \n" +
                "left join pos_mst_province mpro on (msup.province_id = mpro.id)\n" +
                "left join pos_mst_district mdis on (msup.district_id = mdis.id)\n" +
                "left join pos_mst_region mreg on (msup.region_id = mreg.id)").addEntity(MstSupplier.class).list();
        return suppliers;
    }

    @Override
    public void insert(MstSupplier object) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(object);
    }

    @Override
    public void update(MstSupplier object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);

    }

    @Override
    public void delete(MstSupplier object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

    @Override
    public List<MstSupplier> search(String theSearchName) {
        Session session = sessionFactory.getCurrentSession();
        Query theQuery = null;
        if (theSearchName != null & theSearchName.trim().length() > 0) {
            theQuery =
                    session.createSQLQuery("select * from pos_mst_supplier where lower(name) like :theName")
                            .addEntity(MstSupplier.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = session.createSQLQuery("select * from pos_mst_supplier").addEntity(MstSupplier.class);
        }


        List<MstSupplier> suppliers = theQuery.getResultList();
        return suppliers;
    }
}
