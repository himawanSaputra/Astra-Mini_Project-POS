package com.ai.pos.service;

import com.ai.pos.model.MstOutlet;

import java.util.List;

public interface Outlet_Service {

    public void addOutlet(MstOutlet mstOutlet);
    public void saveOrUpdateOutlet(MstOutlet mstOutlet);
    public void updateOutlet(MstOutlet mstOutlet);
    public void deleteOutlet(int id);
    public MstOutlet getMstOutlet(int id);
    public List<MstOutlet> listMstOutlet();
}
