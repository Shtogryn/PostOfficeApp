package com.shtohryn.service;

import com.shtohryn.DAO.implementation.UserAccountDAOImpl;
import com.shtohryn.model.entity.UserAccountModel;

import java.sql.SQLException;
import java.util.List;

public class UserAccountService {
    public List<UserAccountModel> findAll() throws SQLException {
        return new UserAccountDAOImpl().findAll();
    }

    public UserAccountModel findById(Integer integer) throws SQLException {
        return new UserAccountDAOImpl().findBy(integer);
    }

    public int create(UserAccountModel entity) throws SQLException {
        return new UserAccountDAOImpl().create(entity);
    }

    public int update(UserAccountModel entity) throws SQLException {
        return new UserAccountDAOImpl().update(entity);
    }

    public int delete(Integer integer) throws SQLException {
        return new UserAccountDAOImpl().delete(integer);
    }
}
