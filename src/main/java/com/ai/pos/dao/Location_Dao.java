package com.ai.pos.dao;

import com.ai.pos.model.MstDistrict;
import com.ai.pos.model.MstProvince;
import com.ai.pos.model.MstRegion;

import java.util.List;

public interface Location_Dao {
    public MstProvince provinceId(int id);
    public List<MstProvince> listProvinceList();

    public MstRegion regionId(int id);
    public List<MstRegion> listRegionList();

    public MstDistrict districtId(int id);
    public List<MstDistrict> listDisctrictList();
}
