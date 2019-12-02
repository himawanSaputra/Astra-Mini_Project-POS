package com.ai.pos.service;

import com.ai.pos.model.MstRegion;

import java.util.List;

public interface IRegionService {
    List<MstRegion> getByProvince(int id);
}
