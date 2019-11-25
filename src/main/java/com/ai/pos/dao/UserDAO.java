package com.ai.pos.dao;

import com.ai.pos.model.MstUser;

import java.util.List;

public interface UserDAO {
    public MstUser get(Integer id);
    public MstUser getByUsernamePassword(String username, String password);
    public List<MstUser> getAll();
    public void insert(MstUser object);
    public void update(MstUser object);
    public void delete(MstUser object);
}
