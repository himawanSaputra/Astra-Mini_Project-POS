package com.ai.pos.dao;

import com.ai.pos.model.MstItem;

import java.util.List;

public interface MstItemDao {
    public void save(MstItem mstItem);
    public void update(MstItem mstItem);
    public void delete(MstItem mstItem);

    public MstItem getItem(int id);
    public List<MstItem> getAllItem();
    public List<MstItem> getByItemVariantName(String name);
}