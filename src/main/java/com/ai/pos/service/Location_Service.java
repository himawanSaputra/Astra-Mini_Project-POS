package com.ai.pos.service;

import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;

import java.util.List;

public interface Location_Service {
    public MstProvince getProvince(int id);
    public List<MstProvince> getAllProvince();

    public MstRegion getRegion(int id);
    public List<MstRegion> getAllRegion();

    public MstDistrict getDisctrict(int id);
    public List<MstDistrict> getAllDistrict();
}
