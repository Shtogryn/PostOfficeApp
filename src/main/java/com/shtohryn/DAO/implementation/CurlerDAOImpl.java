package com.shtohryn.DAO.implementation;

import com.shtohryn.DAO.interfaces.CurlerDAO;
import com.shtohryn.model.entity.CurlerModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurlerDAOImpl implements CurlerDAO {
    private static final String UPDATE = "UPDATE Curler SET name=?, lastname=? WHERE  id_curler=?";
    private static final String CREATE = "INSERT Curler(id_curler, name, lastname)values(?,?,?)";
    private static final String DELETE = "DELETE Curler WHERE id_curler=?";
    private static final String FIND_ALL = "SELECT * FROM Curler";
    private static final String FIND_BY_ID = "SELECT * FROM Curler WHERE id_curler=?";

    @Override
    public int create(CurlerModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, entity.getCurlerId());
            preparedStatement.setString(2, entity.getNameCurler());
            preparedStatement.setString(3, entity.getLastNameCurler());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(CurlerModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getCurlerId());
            preparedStatement.setString(2, entity.getNameCurler());
            preparedStatement.setString(3, entity.getLastNameCurler());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<CurlerModel> findAll() throws SQLException {
        List<CurlerModel> curlers = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    curlers.add((CurlerModel) new Transformer<>(CurlerModel.class).fromResultSetModel(resultSet));
                }
            }
        }
        return curlers;
    }

    @Override
    public CurlerModel findBy(Integer integer) throws SQLException {
        CurlerModel curler = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, integer);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        curler = (CurlerModel) new Transformer<>(CurlerModel.class).fromResultSetModel(resultSet);
                        break;
                    }
                }
            }
            return curler;
        }

    @Override
    public int delete(Integer integer) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, integer);
            return preparedStatement.executeUpdate();
        }
    }
}
