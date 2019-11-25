package com.ai.pos.dao;

import com.ai.pos.model.MstCategory;

import java.util.List;

public interface MstCategoryDao {
    public void save(MstCategory mstCategory);
    public void update(MstCategory mstCategory);
    public void delete(MstCategory mstCategory);
    public MstCategory getCategory(int id);
    public List<MstCategory> gettAllCategory();
}
