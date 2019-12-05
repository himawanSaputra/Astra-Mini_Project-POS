package com.ai.pos.service;

import com.ai.pos.model.ItemInventory;

import java.util.List;

public interface MstItemInventoryService {
    public void save(ItemInventory itemInventory);
    public void update(ItemInventory itemInventory);
    public void delete(ItemInventory itemInventory);

    public ItemInventory getItemInventory(int id);
    public List<ItemInventory> getAllItemInventory();
}
