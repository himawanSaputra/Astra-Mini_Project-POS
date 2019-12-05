package com.ai.pos.service;

import com.ai.pos.dao.MstItemDao;
import com.ai.pos.model.MstCategory;
import com.ai.pos.model.MstItem;
import com.ai.pos.model.MstItemVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MstItemServiceImpl implements MstItemService {

    @Autowired
    private MstItemDao mstItemDao;

    @Override
    public void save(MstItem mstItem){
        mstItemDao.save(mstItem);
    }

    @Override
    public void update(MstItem mstItem){
        mstItemDao.update(mstItem);
    }

    @Override
    public void delete(MstItem mstItem){
        mstItemDao.delete(mstItem);
    }

    @Override
    public MstItem getItem(int id){
        return mstItemDao.getItem(id);
    }

    @Override
    public List<MstItem> getAllItem(){
        return mstItemDao.getAllItem();
    }

    @Override
    public List<MstItem> getByItemVariantName(String name) {
        return this.mstItemDao.getByItemVariantName(name);
    }

}