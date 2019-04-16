package com.shtohryn.service;

import com.shtohryn.DAO.implementation.MetaDataDAOImpl;
import com.shtohryn.model.metadata.TableMetaData;

import java.sql.SQLException;
import java.util.List;

public class MetaDataService {
    public List<String> findAllTableName() throws SQLException {
        return new MetaDataDAOImpl().findAllTableName();
    }

    public List<TableMetaData> getTablesStructure() throws SQLException {
        return new MetaDataDAOImpl().getTablesStructure();
    }
}
