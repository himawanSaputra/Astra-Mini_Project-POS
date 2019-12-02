package com.ai.pos.service;

import com.ai.pos.model.MstUser;

import java.util.List;

public interface UserService {
    MstUser get(Integer id);
    MstUser getByUsernamePassword(String username, String password);
    List<MstUser> getAll();

    void insert(MstUser object);
    void update(MstUser object);
    void delete(MstUser object);

    boolean resetPassword(String email, String password);
}
