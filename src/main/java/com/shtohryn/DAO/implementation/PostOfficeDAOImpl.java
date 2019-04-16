package com.shtohryn.DAO.implementation;

import com.shtohryn.DAO.interfaces.PostOfficeDAO;
import com.shtohryn.model.entity.FK_PostOffice;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostOfficeDAOImpl implements PostOfficeDAO {
    private static final String FIND_ALL = "SELECT * Post_office Post_office";
    private static final String CREATE = "INSERT Post_office (package_name, unit_name, number) values(?,?,?)";
    private static final String UPDATE = "UPDATE Post_office SET package_name=?, unit_name=?, number=?";
    private static final String DELETE = "DELETE * FROM Post_office";

    @Override
    public int create(FK_PostOffice entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setString(1, entity.getPackageName());
            preparedStatement.setString(2, entity.getUnitName());
            preparedStatement.setInt(3, entity.getNumber());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(FK_PostOffice entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getPackageName());
            preparedStatement.setString(2, entity.getUnitName());
            preparedStatement.setInt(3, entity.getNumber());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<FK_PostOffice> findAll() throws SQLException {
        List<FK_PostOffice> fk_postOffice = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while (rs.next()) {
                    fk_postOffice.add((FK_PostOffice) new Transformer<>(FK_PostOffice.class).fromResultSetModel(rs));
                }
            }
        }
        return fk_postOffice;
    }

    @Override
    public FK_PostOffice findBy(FK_PostOffice fk_postOffice) throws SQLException {
        return null;
    }

    @Override
    public int delete(FK_PostOffice fk_postOffice) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setString(1, fk_postOffice.getPackageName());
            preparedStatement.setString(2, fk_postOffice.getUnitName());
            preparedStatement.setInt(3, fk_postOffice.getNumber());
            return preparedStatement.executeUpdate();
        }
    }
}
