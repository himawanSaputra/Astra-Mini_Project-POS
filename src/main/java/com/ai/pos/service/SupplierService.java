package com.ai.pos.service;

import com.ai.pos.dao.DAO;
import com.ai.pos.model.MstSupplier;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
public class SupplierService implements Service<MstSupplier> {

    @Autowired
    DAO<MstSupplier> mstSupplierDAO;

    @Override
    @Transactional
    public MstSupplier get(Integer id) {
        return mstSupplierDAO.get(id);
    }

    @Override
    @Transactional
    public List<MstSupplier> getAll() {
        return mstSupplierDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(MstSupplier object) {
        mstSupplierDAO.insert(object);
    }

    @Override
    @Transactional
    public void update(MstSupplier object) {
        mstSupplierDAO.update(object);
    }

    @Override
    @Transactional
    public void delete(MstSupplier object) {
        mstSupplierDAO.delete(object);
    }

    @Override
    @Transactional
    public List<MstSupplier> searchSuppliers(String theSearchName) {
        return mstSupplierDAO.search(theSearchName);
    }


}
