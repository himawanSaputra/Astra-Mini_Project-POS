package com.ai.pos.service;

import com.ai.pos.dao.UserDAO;
import com.ai.pos.model.MstUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements com.ai.pos.service.Service<MstUser> {

    @Autowired
    UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public MstUser get(Integer id) {
        return this.userDAO.get(id);
    }

    public MstUser getByUsernamePassword(String username, String password){
        return this.userDAO.getByUsernamePassword(username, password);
    }

    @Override
    public List<MstUser> getAll() {
        return this.userDAO.getAll();
    }

    @Override
    public void insert(MstUser object){
        this.userDAO.insert(object);
    }

    @Override
    public void update(MstUser object) {
        this.userDAO.update(object);
    }

    @Override
    public void delete(MstUser object) {
        this.userDAO.delete(object);
    }

}
