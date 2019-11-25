package com.ai.pos.service;

import com.ai.pos.dao.CustomerDao;
import com.ai.pos.model.MstCustomer;
import com.ai.pos.model.MstOutlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Customer_ServiceImpl implements Customer_Service {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void addCustomer(MstCustomer mstCustomer) {
        this.customerDao.addCustomer(mstCustomer);
    }

    @Override
    @Transactional
    public void updateCustomer(MstCustomer mstCustomer) {
        this.customerDao.updateCustomer(mstCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(MstCustomer mstCustomer) {
        this.customerDao.deleteCustomer(mstCustomer);
    }

    @Override
    @Transactional
    public MstCustomer getMstCustomer(int id) {
        return this.customerDao.findOne(id);
    }

    @Override
    public List<MstCustomer> listMstCustomer() {
        return this.listMstCustomer();
    }
}
