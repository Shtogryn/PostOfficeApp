package com.shtohryn.service;

import com.shtohryn.DAO.implementation.PackageAndUserDAOImpl;
import com.shtohryn.model.entity.FK_PackageAndUser;

import java.sql.SQLException;
import java.util.List;

public class PackageAndUserService {
    public List<FK_PackageAndUser> findAll() throws SQLException {
        return new PackageAndUserDAOImpl().findAll();
    }

    public int create(FK_PackageAndUser entity) throws SQLException {
        return new PackageAndUserDAOImpl().create(entity);
    }

    public int update(FK_PackageAndUser entity) throws SQLException {
        return new PackageAndUserDAOImpl().update(entity);
    }

    public int delete(FK_PackageAndUser s) throws SQLException {
        return new PackageAndUserDAOImpl().delete(s);
    }

}
