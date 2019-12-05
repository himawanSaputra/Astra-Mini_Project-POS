package com.ai.pos.service;

import com.ai.pos.dao.TPr_Dao;
import com.ai.pos.model.TPr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TPr_ServiceImpl implements TPr_Service{

    @Autowired
    TPr_Dao tPr_dao;

    @Override
    public void addTPr(TPr tPr) {
        this.tPr_dao.addPr(tPr);
    }

    @Override
    public void saveOrUpdateTPr(TPr tPr) {
        this.tPr_dao.saveOrUpdatePr(tPr);
    }

    @Override
    public void updateTPr(TPr tPr) {
        this.tPr_dao.updatePr(tPr);
    }

    @Override
    public void deleteTPr(TPr tPr) {
        this.tPr_dao.deletePr(tPr);
    }

    @Override
    public TPr getTPr(int id) {
        return this.tPr_dao.findOne(id);
    }

    @Override
    public List<TPr> listTPr() {
        return tPr_dao.listTPrList();
    }
}
