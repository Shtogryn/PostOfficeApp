package com.shtohryn.DAO.implementation;

import com.shtohryn.DAO.interfaces.PackageAndUserDAO;
import com.shtohryn.model.entity.CurlerModel;
import com.shtohryn.model.entity.FK_PackageAndUser;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageAndUserDAOImpl implements PackageAndUserDAO {
    private static final String FIND_ALL = "SELECT * FROM Package_and_User";
    private static final String CREATE = "INSERT Package_and_User (package_name, id_table, order_amount) values(?,?,?)";
    private static final String UPDATE = "UPDATE Package_and_User SET package_name=?, price=?, package_number=?";
    private static final String DELETE = "DELETE * FROM Package_and_User";

    @Override
    public int create(FK_PackageAndUser entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getPackageName());
            ps.setInt(2, entity.getIdTable());
            ps.setString(3, entity.getOrderAmount());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(FK_PackageAndUser entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getPackageName());
            ps.setInt(2, entity.getIdTable());
            ps.setString(3, entity.getOrderAmount());
            return ps.executeUpdate();
        }
    }

    @Override
    public List<FK_PackageAndUser> findAll() throws SQLException {
        List<FK_PackageAndUser> list = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    list.add((FK_PackageAndUser) new Transformer<>(FK_PackageAndUser.class).fromResultSetModel(resultSet));
                }
            }
        }
        return list;
    }

    @Override
    public FK_PackageAndUser findBy(FK_PackageAndUser fk_packageAndUser) throws SQLException {
        return null;
    }

    @Override
    public int delete(FK_PackageAndUser entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setString(1, entity.getPackageName());
            return ps.executeUpdate();
        }
    }
}
