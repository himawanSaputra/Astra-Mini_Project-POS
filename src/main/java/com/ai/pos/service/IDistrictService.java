package com.ai.pos.service;

import com.ai.pos.model.MstDistrict;

import java.util.List;

public interface IDistrictService {
    List<MstDistrict> getByRegion(int id);
}
