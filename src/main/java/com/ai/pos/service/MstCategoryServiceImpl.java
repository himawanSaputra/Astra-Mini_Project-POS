package com.ai.pos.service;

import com.ai.pos.dao.MstCategoryDao;
import com.ai.pos.model.MstCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MstCategoryServiceImpl implements MstCategoryService{

    @Autowired
    private MstCategoryDao mstCategoryDao;

    public void save(MstCategory mstCategory){
        mstCategoryDao.save(mstCategory);
    }

    public void update(MstCategory mstCategory){
        mstCategoryDao.update(mstCategory);
    }

    public void delete(MstCategory mstCategory){
        mstCategoryDao.delete(mstCategory);
    }

    public MstCategory getCategory(int id){
        return mstCategoryDao.getCategory(id);
    }

    public List<MstCategory> getAllCategory(){
        return mstCategoryDao.getAllCategory();
    }


}
