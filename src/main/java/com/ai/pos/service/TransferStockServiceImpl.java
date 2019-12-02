package com.ai.pos.service;

import com.ai.pos.dao.TransferStockDAO;
import com.ai.pos.model.TTransferStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransferStockServiceImpl implements TransferStockService {

    @Autowired
    TransferStockDAO transferStockDAO;

    @Override
    public TTransferStock get(Integer id) {
        return this.transferStockDAO.get(id);
    }

    @Override
    public List<TTransferStock> getAll() {
        return this.transferStockDAO.getAll();
    }

    @Override
    public List<TTransferStock> getByFromOutletId(int id) {
        return this.transferStockDAO.getByFromOutletId(id);
    }

    @Override
    public void insert(TTransferStock object) {
        this.transferStockDAO.insert(object);
    }

    @Override
    public void update(TTransferStock object) {
        this.transferStockDAO.update(object);
    }

    @Override
    public void delete(TTransferStock object) {
        this.transferStockDAO.delete(object);
    }
}
