package com.ai.pos.service;

import com.ai.pos.model.TPr;

import java.util.List;

public interface TPr_Service {

    public void addTPr(TPr tPr);
    public void saveOrUpdateTPr(TPr tPr);
    public void updateTPr(TPr tPr);
    public void deleteTPr(TPr tPr);
    public TPr getTPr(int id);
    public List<TPr> listTPr();
}
