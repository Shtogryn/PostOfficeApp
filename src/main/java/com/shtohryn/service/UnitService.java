package com.shtohryn.service;


import com.shtohryn.DAO.implementation.UnitDAOImpl;
import com.shtohryn.model.entity.UnitModel;

import java.sql.SQLException;
import java.util.List;

public class UnitService  {
    public List<UnitModel> findAll() throws SQLException {
        return new UnitDAOImpl().findAll();
    }

    public UnitModel findById(String s) throws SQLException{
        return new UnitDAOImpl().findBy(s);
    }

    public int create(UnitModel entity) throws SQLException{
        return new UnitDAOImpl().create(entity);
    }

    public int update(UnitModel entity) throws SQLException{
        return new UnitDAOImpl().update(entity);
    }

    public int delete(String s) throws SQLException{
        return new UnitDAOImpl().delete(s);
    }
}
