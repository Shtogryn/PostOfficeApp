package com.shtohryn.service;

import com.shtohryn.DAO.implementation.PackageAndUserDAOImpl;
import com.shtohryn.DAO.implementation.PackageDAOImpl;
import com.shtohryn.model.entity.PackageModel;

import java.sql.SQLException;
import java.util.List;

public class PackageService {
    public List<PackageModel> findAll() throws SQLException {
        return new PackageDAOImpl().findAll();
    }

    public PackageModel findById(String s) throws SQLException {
        return new PackageDAOImpl().findBy(s);
    }

    public int create(PackageModel entity) throws SQLException {
        return new PackageDAOImpl().create(entity);
    }

    public int update(PackageModel entity) throws SQLException {
        return new PackageDAOImpl().update(entity);
    }

    public int delete(String s) throws SQLException {
        return new PackageDAOImpl().delete(s);
    }

}
