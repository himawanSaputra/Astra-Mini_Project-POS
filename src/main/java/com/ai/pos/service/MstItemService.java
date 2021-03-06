package com.ai.pos.service;

import com.ai.pos.model.MstCategory;
import com.ai.pos.model.MstItem;
import com.ai.pos.model.MstItemVariant;

import java.util.List;

public interface MstItemService {
    public void save(MstItem mstItem);
    public void update(MstItem mstItem);
    public void delete(MstItem mstItem);

    public MstItem getItem(int id);
    public List<MstItem> getAllItem();
    public List<MstItem> getByItemVariantName(String name);
}