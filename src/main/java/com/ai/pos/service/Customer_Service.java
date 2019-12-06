
package com.ai.pos.service;

import com.ai.pos.model.MstCustomer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface Customer_Service {

    public void addCustomer(MstCustomer mstCustomer);
    public void updateCustomer(MstCustomer mstCustomer);
    public void deleteCustomer(MstCustomer mstCustomer);
    public MstCustomer getMstCustomer(int id);
    public List<MstCustomer> listMstCustomer();
}