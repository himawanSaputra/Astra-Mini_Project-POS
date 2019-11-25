package com.ai.pos.dao;

import com.ai.pos.model.MstCustomer;

import java.util.List;

public interface CustomerDao {
    public void addCustomer(MstCustomer mstCustomer);
    public void updateCustomer(MstCustomer mstCustomer);
    public void deleteCustomer(MstCustomer mstCustomer);
    public MstCustomer findOne(int id);
    List<MstCustomer> listMstCustomer();
}
