package com.ai.pos.service;

import com.ai.pos.dao.OutletDao;
import com.ai.pos.model.MstOutlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Outlet_ServiceImpl implements Outlet_Service {

    @Autowired
    OutletDao outletDao;

    @Override
    public void addOutlet(MstOutlet mstOutlet) {
        this.outletDao.addOutlet(mstOutlet);
    }

    @Override
    public void saveOrUpdateOutlet(MstOutlet mstOutlet) {
        this.outletDao.saveOrUpdateOutlet(mstOutlet);
    }

    @Override
    public void updateOutlet(MstOutlet mstOutlet) {
        this.outletDao.updateOutlet(mstOutlet);
    }

    @Override
    public void deleteOutlet(int id) {
        this.outletDao.deleteOutlet(id);
    }

    @Override
    public MstOutlet getMstOutlet(int id) {
        return this.outletDao.findOne(id);
    }

    @Override
    public List<MstOutlet> listMstOutlet() {
        return outletDao.listMstOutlet();
    }
}
