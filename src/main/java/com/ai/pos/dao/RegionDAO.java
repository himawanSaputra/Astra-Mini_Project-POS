package com.ai.pos.dao;

import com.ai.pos.model.MstRegion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDAO implements DAO<MstRegion>, IRegionCustomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public MstRegion get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstRegion.class, id);
    }

    @Override
    public List<MstRegion> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstRegion.class).list();
    }

    @Override
    public void insert(MstRegion object) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(object);
    }

    @Override
    public void update(MstRegion object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public void delete(MstRegion object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

    @Override
    public List<MstRegion> search(String theSearchName) {
        return null;
    }



    @Override
    public List<MstRegion> getByProvince(int id) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM pos_mst_region preg ")
                .append("WHERE preg.province_id = :theProvinceId");
        Query<MstRegion> theQuery = session.createSQLQuery(stringBuilder.toString()).addEntity(MstRegion.class);

        theQuery.setParameter("theProvinceId", id);
        return theQuery.getResultList();
    }

}
