package com.ai.pos.service;

import com.ai.pos.dao.MstItemInventoryDao;
import com.ai.pos.model.ItemInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MstItemInventoryServiceImpl implements MstItemInventoryService {

    @Autowired
    private MstItemInventoryDao itemInventoryDao;

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
