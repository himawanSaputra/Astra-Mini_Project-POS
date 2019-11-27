package com.ai.pos.service;

import com.ai.pos.dao.Employee_Dao;
import com.ai.pos.dao.UserDAO;
import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    Employee_Dao employee_dao;

    @Override
    public MstUser get(Integer id) {
        return this.userDAO.get(id);
    }

    @Override
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

    @Override
    public boolean resetPassword(String email, String password) {
        //GET EMPLOYEE BY EMAIL (UNIQUE)
        MstEmployee employee = this.employee_dao.getEmployeeByEmail(email);
        //CHECK IF EMPLOYEE IS NULL (EMAIL DOES NOT EXIST)
        if(employee == null){
            return false;
        }
        //GET USER BY EMPLOYEE
        MstUser user = this.userDAO.getByEmployeeId(employee.getId());
        //UPDATE THE PASSWORD
        user.setPassword(password);
        this.userDAO.update(user);
        return true;
    }

}
