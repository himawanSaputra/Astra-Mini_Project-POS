package com.ai.pos.dao;

import com.ai.pos.model.MstDistrict;

import java.util.List;

public interface IDistrictCustomDAO {
    List<MstDistrict> getByRegion(int id);
}
