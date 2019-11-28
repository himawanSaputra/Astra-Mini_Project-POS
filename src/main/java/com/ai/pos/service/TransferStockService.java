package com.ai.pos.service;

import com.ai.pos.model.TTransferStock;

import java.util.List;

public interface TransferStockService {
    public TTransferStock get(Integer id);
    public List<TTransferStock> getAll();
    public List<TTransferStock> getByFromOutletId(int id);

    public void insert(TTransferStock object);
    public void update(TTransferStock object);
    public void delete(TTransferStock object);
}
