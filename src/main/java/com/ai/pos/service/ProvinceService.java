package com.ai.pos.service;

import com.ai.pos.dao.DAO;
import com.ai.pos.model.MstProvince;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
public class ProvinceService implements Service<MstProvince> {

    @Autowired
    private DAO<MstProvince> mstProvinceDAO;

    @Override
    @Transactional
    public MstProvince get(Integer id) {
        return mstProvinceDAO.get(id);
    }

    @Override
    @Transactional
    public List<MstProvince> getAll() {
        return mstProvinceDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(MstProvince object) {
        mstProvinceDAO.insert(object);
    }

    @Override
    @Transactional
    public void update(MstProvince object) {
        mstProvinceDAO.update(object);
    }

    @Override
    @Transactional
    public void delete(MstProvince object) {
        mstProvinceDAO.delete(object);
    }

    @Override
    public List<MstProvince> searchSuppliers(String theSearchName) {
        return null;
    }
}
