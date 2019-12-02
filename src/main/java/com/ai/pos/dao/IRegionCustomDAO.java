package com.ai.pos.dao;

import com.ai.pos.model.MstRegion;

import java.util.List;

public interface IRegionCustomDAO {
    List<MstRegion> getByProvince(int id);
}
