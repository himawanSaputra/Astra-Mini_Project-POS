package com.ai.pos.dao;

import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Location_DaoImpl implements Location_Dao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public MstProvince provinceId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstProvince.class, id);
    }

    @Override
    public List<MstProvince> listProvinceList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstProvince.class).list();
    }

    @Override
    public MstRegion regionId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstRegion.class, id);
    }

    @Override
    public List<MstRegion> listRegionList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstRegion.class).list();
    }

    @Override
    public MstDistrict districtId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstDistrict.class, id);
    }

    @Override
    public List<MstDistrict> listDisctrictList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstDistrict.class).list();
    }
}
