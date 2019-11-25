package com.ai.pos.service;

import com.ai.pos.dao.OutletDao;
import com.ai.pos.model.MstOutlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Outlet_ServiceImpl implements Outlet_Service {

    private OutletDao outletDao;

    public void setOutletDao(OutletDao outletDao) {
        this.outletDao = outletDao;
    }

    @Override
    @Transactional
    public void addOutlet(MstOutlet mstOutlet) {
        this.outletDao.addOutlet(mstOutlet);
    }

    @Override
    @Transactional
    public void updateOutlet(MstOutlet mstOutlet) {
        this.outletDao.updateOutlet(mstOutlet);
    }

    @Override
    @Transactional
    public void deleteOutlet(int id) {
        this.outletDao.deleteOutlet(id);
    }

    @Override
    @Transactional
    public MstOutlet getMstOutlet(int id) {
        return this.outletDao.findOne(id);
    }

    @Override
    public List<MstOutlet> listMstOutlet() {
        return this.listMstOutlet();
    }
}
