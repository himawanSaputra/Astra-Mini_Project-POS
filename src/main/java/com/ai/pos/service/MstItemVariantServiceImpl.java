package com.ai.pos.service;

import com.ai.pos.dao.MstItemVariantDao;
import com.ai.pos.model.MstItemVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MstItemVariantServiceImpl implements MstItemVariantService {

    @Autowired
    private MstItemVariantDao mstItemVariantDao;

    @Override
    public void save(MstItemVariant mstItemVariant) {
        mstItemVariantDao.save(mstItemVariant);
    }

    @Override
    public void update(MstItemVariant mstItemVariant) {
        mstItemVariantDao.update(mstItemVariant);
    }

    @Override
    public void delete(MstItemVariant mstItemVariant) {
        mstItemVariantDao.delete(mstItemVariant);
    }

    @Override
    public MstItemVariant getItemVariant(int id) {
        return mstItemVariantDao.getItemVariant(id);
    }

    @Override
    public List<MstItemVariant> getAllItemVariant() {
        return mstItemVariantDao.getAllItemVariant();
    }
}
