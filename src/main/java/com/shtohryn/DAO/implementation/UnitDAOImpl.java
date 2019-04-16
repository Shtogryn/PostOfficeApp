package com.shtohryn.DAO.implementation;

import com.shtohryn.DAO.interfaces.UnitDAO;
import com.shtohryn.model.entity.UnitModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDAOImpl implements UnitDAO {
    private static final String FIND_ALL = "SELECT * FROM Unit ";
    private static final String FIND_BY_ID = "SELECT * FROM Unit WHERE unit_name=?";
    private static final String DELETE = "DELETE FROM Unit WHERE unit_name=?";
    private static final String CREATE = "INSERT Unit(unit_name) VALUES (?)";
    private static final String UPDATE = "UPDATE Unit WHERE unit_name=?";

    @Override
    public int create(UnitModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getUnitName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(UnitModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getUnitName());
            return ps.executeUpdate();
        }
    }

    @Override
    public List<UnitModel> findAll() throws SQLException {
        List<UnitModel> units = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL)) {
                while (rs.next()) {
                    units.add((UnitModel) new Transformer<>(UnitModel.class).fromResultSetModel(rs));
                }
            }
        }
        return units;
    }

    @Override
    public UnitModel findBy(String s) throws SQLException {
        UnitModel model = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1, s);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    model = (UnitModel) new Transformer<>(UnitModel.class).fromResultSetModel(rs);
                }
            }
        }
        return model;
    }

    @Override
    public int delete(String s) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setString(1, s);
            return ps.executeUpdate();
        }
    }
}
