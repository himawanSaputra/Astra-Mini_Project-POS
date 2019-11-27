package com.ai.pos.service;

import com.ai.pos.model.MstRole;

import java.util.List;

public interface Role_Service {

    public void addRole(MstRole mstRole);
    public void updateRole(MstRole mstRole);
    public void deleteRole(MstRole mstRole);
    public MstRole getMstRole(int id);
    public List<MstRole> listMstRole();
}