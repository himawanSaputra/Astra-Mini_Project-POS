package com.ai.pos.service;

import com.ai.pos.model.TPrDetail;

import java.util.List;

public interface TPrDetail_Service {
    public void addTPrDetail(TPrDetail tPrDetail);
    public void saveOrUpdateTPrDetail(TPrDetail tPrDetail);
    public void updateTPrDetail(TPrDetail tPrDetail);
    public void deleteTPrDetail(TPrDetail tPrDetail);
    public TPrDetail getTPrDetail(int id);
    public List<TPrDetail> listTPrDetail();
}
