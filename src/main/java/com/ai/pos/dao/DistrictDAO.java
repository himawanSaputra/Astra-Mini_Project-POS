package com.ai.pos.dao;

import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstSupplier;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DistrictDAO implements DAO<MstDistrict>, IDistrictCustomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public MstDistrict get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        MstDistrict theDistrict = session.get(MstDistrict.class, id);
        return theDistrict;
    }

    @Override
    public List<MstDistrict> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstDistrict.class).list();
    }

    @Override
    public void insert(MstDistrict object) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(object);
    }

    @Override
    public void update(MstDistrict object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);

    }

    @Override
    public void delete(MstDistrict object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

    @Override
    public List<MstDistrict> search(String theSearchName) {
        return null;
    }

    @Override
    public List<MstDistrict> getByRegion(int id) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder builder = new StringBuilder("SELECT * FROM pos_mst_district pmdis ")
                .append("WHERE pmdis.region_id = :theRegionId");
        Query<MstDistrict> theQuery = session.createSQLQuery(builder.toString()).addEntity(MstDistrict.class);
        theQuery.setParameter("theRegionId", id);
        List<MstDistrict> districts = theQuery.getResultList();
        return districts;
    }
}
