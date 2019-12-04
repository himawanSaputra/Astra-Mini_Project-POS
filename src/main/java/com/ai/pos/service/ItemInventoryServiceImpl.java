package com.ai.pos.service;

import com.ai.pos.dao.ItemInventoryDao;
import com.ai.pos.model.ItemInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemInventoryServiceImpl implements ItemInventoryService {

    @Autowired
    private ItemInventoryDao itemInventoryDao;

    @Override
    public void save(ItemInventory itemInventory) {
        itemInventoryDao.save(itemInventory);
    }

    @Override
    public void update(ItemInventory itemInventory) {
        itemInventoryDao.update(itemInventory);
    }

    @Override
    public void delete(ItemInventory itemInventory) {
        itemInventoryDao.delete(itemInventory);
    }

    @Override
    public ItemInventory getItemInventory(int id) {
        return itemInventoryDao.getItemInventory(id);
    }

    @Override
    public List<ItemInventory> getAllItemInventory() {
        return itemInventoryDao.getAllItemInventory();
    }
}
