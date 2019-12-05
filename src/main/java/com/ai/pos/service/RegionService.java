package com.ai.pos.service;

import com.ai.pos.dao.DAO;
import com.ai.pos.dao.IRegionCustomDAO;
import com.ai.pos.model.MstRegion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class RegionService implements Service<MstRegion>, IRegionService {

    @Autowired
    private DAO<MstRegion> mstRegionDAO;

    @Autowired
    private IRegionCustomDAO mstRegionCustomDAO;

    @Override
    @Transactional
    public MstRegion get(Integer id) {
        return mstRegionDAO.get(id);
    }

    @Override
    @Transactional
    public List<MstRegion> getAll() {
        return mstRegionDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(MstRegion object) {
        mstRegionDAO.insert(object);
    }

    @Override
    @Transactional
    public void update(MstRegion object) {
        mstRegionDAO.update(object);
    }

    @Override
    @Transactional
    public void delete(MstRegion object) {
        mstRegionDAO.delete(object);
    }

    public List<MstRegion> searchSuppliers(String theSearchName) {
        return null;
    }

    @Override
    @Transactional
    public List<MstRegion> getByProvince(int id){
        return mstRegionCustomDAO.getByProvince(id);
    }
}