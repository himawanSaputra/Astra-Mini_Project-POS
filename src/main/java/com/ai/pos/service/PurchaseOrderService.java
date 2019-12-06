package com.ai.pos.service;

import com.ai.pos.dao.DAO;
import com.ai.pos.model.TPo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class PurchaseOrderService implements Service<TPo> {

    @Autowired
    private DAO<TPo> purchaseOrderDAO;

    @Override
    public TPo get(Integer id) {
        return purchaseOrderDAO.get(id);
    }

    @Override
    public List<TPo> getAll() {
        return purchaseOrderDAO.getAll();
    }

    @Override
    public void insert(TPo po) {
        purchaseOrderDAO.insert(po);
    }

    @Override
    public void update(TPo po) {
        purchaseOrderDAO.update(po);
    }

    @Override
    public void delete(TPo po) {
        purchaseOrderDAO.delete(po);
    }

    @Override
    public List<TPo> searchSuppliers(String theSearchName) {
        return null;
    }
}
