package com.ai.pos.dao;

import com.ai.pos.model.MstRole;

import java.util.List;

public interface Role_Dao {

    public void addRole(MstRole mstRole);
    public void updateRole(MstRole mstRole);
    public void deleteRole(MstRole mstRole);
    public MstRole findOne(int id);
    public List<MstRole> listMstRole();
}