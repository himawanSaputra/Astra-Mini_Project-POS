package com.ai.pos.service;

import com.ai.pos.dao.DAO;
import com.ai.pos.dao.IDistrictCustomDAO;
import com.ai.pos.model.MstDistrict;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class DistrictService implements Service<MstDistrict>, IDistrictService {

    @Autowired
    private DAO<MstDistrict> mstDistrictDAO;

    @Autowired
    private IDistrictCustomDAO iDistrictCustomDAO;

    @Override
    public MstDistrict get(Integer id) {
        return mstDistrictDAO.get(id);
    }

    @Override
    public List<MstDistrict> getAll() {
        return mstDistrictDAO.getAll();
    }

    @Override
    public void insert(MstDistrict object) {
        mstDistrictDAO.insert(object);
    }

    @Override
    public void update(MstDistrict object) {
        mstDistrictDAO.update(object);
    }

    @Override
    public void delete(MstDistrict object) {
        mstDistrictDAO.delete(object);
    }

    @Override
    public List<MstDistrict> searchSuppliers(String theSearchName) {
        return null;
    }

    @Override
    public List<MstDistrict> getByRegion(int id) {
        return iDistrictCustomDAO.getByRegion(id);
    }

}
