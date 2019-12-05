package com.ai.pos.service;

import com.ai.pos.dao.TPrDetail_Dao;
import com.ai.pos.model.TPrDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TPrDetail_ServiceImpl implements TPrDetail_Service{

    @Autowired
    TPrDetail_Dao tPrDetail_dao;


    @Override
    public void addTPrDetail(TPrDetail tPrDetail) {
        this.tPrDetail_dao.addPrDetail(tPrDetail);
    }

    @Override
    public void saveOrUpdateTPrDetail(TPrDetail tPrDetail) {
        this.tPrDetail_dao.saveOrUpdatePrDetail(tPrDetail);
    }

    @Override
    public void updateTPrDetail(TPrDetail tPrDetail) {
        this.tPrDetail_dao.updatePrDetail(tPrDetail);
    }

    @Override
    public void deleteTPrDetail(TPrDetail tPrDetail) {
        this.tPrDetail_dao.deletePrDetail(tPrDetail);
    }

    @Override
    public TPrDetail getTPrDetail(int id) {
        return this.tPrDetail_dao.findOne(id);
    }

    @Override
    public List<TPrDetail> listTPrDetail() {
        return tPrDetail_dao.listTPrDetailList();
    }
}
