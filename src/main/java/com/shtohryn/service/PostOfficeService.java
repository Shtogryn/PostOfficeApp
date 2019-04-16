package com.shtohryn.service;


import com.shtohryn.DAO.implementation.PostOfficeDAOImpl;
import com.shtohryn.model.entity.FK_PostOffice;

import java.sql.SQLException;
import java.util.List;

public class PostOfficeService {
    public List<FK_PostOffice> findAll() throws SQLException {
        return new PostOfficeDAOImpl().findAll();
    }

    public int create(FK_PostOffice entity) throws SQLException {
        return new PostOfficeDAOImpl().create(entity);
    }

    public int update(FK_PostOffice entity) throws SQLException {
        return new PostOfficeDAOImpl().update(entity);
    }

    public int delete(FK_PostOffice s) throws SQLException {
        return new PostOfficeDAOImpl().delete(s);
    }

}
