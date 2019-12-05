package com.ai.pos.dao;

import com.ai.pos.model.TPr;

import java.util.List;

public interface TPr_Dao {
    public void addPr(TPr tPr);
    public void updatePr(TPr tPr);
    public void deletePr(TPr tPr);
    public void saveOrUpdatePr(TPr tPr);
    public TPr findOne(int id);
    public List<TPr> listTPrList();
}
