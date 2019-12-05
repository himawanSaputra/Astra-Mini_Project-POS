package com.ai.pos.dao;

import com.ai.pos.model.ItemInventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MstItemInventoryDaoImpl implements MstItemInventoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ItemInventory itemInventory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(itemInventory);
        session.flush();
    }

    @Override
    public void update(ItemInventory itemInventory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(itemInventory);
        session.flush();
    }

    @Override
    public void delete(ItemInventory itemInventory) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(itemInventory);
        session.flush();
    }

    @Override
    public ItemInventory getItemInventory(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ItemInventory.class, id);
    }

    @Override
    public List<ItemInventory> getAllItemInventory() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(ItemInventory.class).list();
    }
}
