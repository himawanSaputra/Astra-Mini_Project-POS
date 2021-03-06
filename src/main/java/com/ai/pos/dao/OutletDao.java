package com.ai.pos.dao;

import com.ai.pos.model.MstOutlet;

import java.util.List;

public interface OutletDao {
    public void addOutlet(MstOutlet mstOutlet);
    public void updateOutlet(MstOutlet mstOutlet);
    public void deleteOutlet(int id);
    public MstOutlet findOne(int id);
    public List<MstOutlet> listMstOutlet();
    public void saveOrUpdateOutlet(MstOutlet mstOutlet);
}
