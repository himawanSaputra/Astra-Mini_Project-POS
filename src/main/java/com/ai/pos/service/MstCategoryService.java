package com.ai.pos.service;

import com.ai.pos.model.MstCategory;

import java.util.List;

public interface MstCategoryService {
    public void save(MstCategory mstCategory);
    public void update(MstCategory mstCategory);
    public void delete(MstCategory mstCategory);
    public MstCategory getCategory(int id);
    public List<MstCategory> getAllCategory();
    public void saveOrUpdate(MstCategory mstCategory);
}
