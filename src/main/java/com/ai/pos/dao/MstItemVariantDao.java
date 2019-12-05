package com.ai.pos.dao;

import com.ai.pos.model.MstItemVariant;

import java.util.List;

public interface MstItemVariantDao {
    public void save(MstItemVariant mstItemVariant);
    public void update(MstItemVariant mstItemVariant);
    public void delete(MstItemVariant mstItemVariant);

    public MstItemVariant getItemVariant(int id);
    List<MstItemVariant> getAllItemVariant();
}
