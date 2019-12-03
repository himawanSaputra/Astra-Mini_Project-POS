package com.ai.pos.service;

import com.ai.pos.model.ItemInventory;
import com.ai.pos.model.MstItem;

import java.util.List;

public interface ItemInventoryService {
    public void save(ItemInventory itemInventory);
    public void update(ItemInventory itemInventory);
    public void delete(ItemInventory itemInventory);

    public ItemInventory getItemInventory(int id);
    public List<ItemInventory> getAllItemInventory();
//    public List<MstItem> getByItemVariantName(String name);
}
