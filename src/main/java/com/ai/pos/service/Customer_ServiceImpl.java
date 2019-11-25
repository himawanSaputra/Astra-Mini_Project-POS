package com.ai.pos.service;

import com.ai.pos.dao.CustomerDao;
import com.ai.pos.model.MstCustomer;
import com.ai.pos.model.MstOutlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Customer_ServiceImpl implements Customer_Service {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(MstCustomer mstCustomer) {
        this.customerDao.addCustomer(mstCustomer);
    }

    @Override
    public void updateCustomer(MstCustomer mstCustomer) {
        this.customerDao.updateCustomer(mstCustomer);
    }

    @Override
    public void deleteCustomer(MstCustomer mstCustomer) {
        this.customerDao.deleteCustomer(mstCustomer);
    }

    @Override
    public MstCustomer getMstCustomer(int id) {
        return this.customerDao.findOne(id);
    }

    @Override
    public List<MstCustomer> listMstCustomer() {
        return customerDao.listMstCustomer();
    }
}
