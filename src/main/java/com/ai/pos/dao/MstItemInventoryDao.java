package com.ai.pos.dao;

import com.ai.pos.model.ItemInventory;

import java.util.List;

public interface MstItemInventoryDao {
    public void save(ItemInventory itemInventory);
    public void update(ItemInventory itemInventory);
    public void delete(ItemInventory itemInventory);

    public ItemInventory getItemInventory(int id);
    public List<ItemInventory> getAllItemInventory();
//    public List<ItemInventory> getByItemVariantName(String name);
}
