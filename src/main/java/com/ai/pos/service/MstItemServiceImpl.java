package com.ai.pos.service;

import com.ai.pos.dao.MstItemDao;
import com.ai.pos.model.MstItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MstItemServiceImpl implements MstItemService {

    @Autowired
    private MstItemDao mstItemDao;

    public void setMstItemDao(MstItemDao mstItemDao) {
        this.mstItemDao = mstItemDao;
    }

    public void save(MstItem mstItem){
        mstItemDao.save(mstItem);
    }

    public void update(MstItem mstItem){
        mstItemDao.update(mstItem);
    }

    public void delete(MstItem mstItem){
        mstItemDao.delete(mstItem);
    }

    public MstItem getItem(int id){
        return mstItemDao.getItem(id);
    }

    public List<MstItem> getAllItem(){
        return mstItemDao.getAllItem();
    }

    @Override
    public List<MstItem> getByItemVariantName(String name) {
        return this.mstItemDao.getByItemVariantName(name);
    }
}