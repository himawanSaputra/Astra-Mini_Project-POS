package com.ai.pos.dao;

import com.ai.pos.model.TPrDetail;

import java.util.List;

public interface TPrDetail_Dao {
    public void addPrDetail(TPrDetail tPrDetail);
    public void updatePrDetail(TPrDetail tPrDetail);
    public void deletePrDetail(TPrDetail tPrDetail);
    public void saveOrUpdatePrDetail(TPrDetail tPrDetail);
    public TPrDetail findOne(int id);
    public List<TPrDetail> listTPrDetailList();
}
