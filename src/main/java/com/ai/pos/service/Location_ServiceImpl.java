package com.ai.pos.service;

import com.ai.pos.dao.Location_Dao;
import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Location_ServiceImpl implements Location_Service {

    @Autowired
    Location_Dao location_dao;

    @Override
    public MstProvince getProvince(int id) {
        return this.location_dao.provinceId(id);
    }

    @Override
    public List<MstProvince> getAllProvince() {
        return this.location_dao.listProvinceList();
    }

    @Override
    public MstRegion getRegion(int id) {
        return this.location_dao.regionId(id);
    }

    @Override
    public List<MstRegion> getAllRegion() {
        return this.location_dao.listRegionList();
    }

    @Override
    public MstDistrict getDisctrict(int id) {
        return this.location_dao.districtId(id);
    }

    @Override
    public List<MstDistrict> getAllDistrict() {
        return this.location_dao.listDisctrictList();
    }
}
