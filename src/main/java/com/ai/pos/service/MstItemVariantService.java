package com.ai.pos.service;

import com.ai.pos.model.MstItemVariant;

import java.util.List;

public interface MstItemVariantService {
    public void save(MstItemVariant mstItemVariant);
    public void update(MstItemVariant mstItemVariant);
    public void delete(MstItemVariant mstItemVariant);

    public MstItemVariant getItemVariant(int id);
    List<MstItemVariant> getAllItemVariant();
}
