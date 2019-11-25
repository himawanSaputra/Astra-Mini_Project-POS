package com.ai.pos.service;


import com.ai.pos.dao.Role_Dao;
import com.ai.pos.model.MstRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Role_ServiceImpl implements Role_Service {

    private Role_Dao role_dao;

    public void setRole_dao(Role_Dao role_dao) {
        this.role_dao = role_dao;
    }

    @Override
    @Transactional
    public void addRole(MstRole mstRole) {
        this.role_dao.addRole(mstRole);
    }

    @Override
    @Transactional
    public void updateRole(MstRole mstRole) {
        this.role_dao.updateRole(mstRole);
    }

    @Override
    @Transactional
    public void deleteRole(MstRole mstRole) {
        this.role_dao.deleteRole(mstRole);
    }

    @Override
    @Transactional
    public MstRole getMstRole(int id) {
        return this.role_dao.findOne(id);
    }

    @Override
    @Transactional
    public List<MstRole> listMstRole() {
        return this.role_dao.listMstRole();
    }
}
