package com.shtohryn.DAO.implementation;

import com.shtohryn.DAO.interfaces.PackageDAO;
import com.shtohryn.model.entity.PackageModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageDAOImpl implements PackageDAO {
    private static final String FIND_ALL = "SELECT * FROM Pakage";
    private static final String FIND_BY_ID = "sELECT * FROM Pakage WHERE package_name=?";
    private static final String CREATE = "INSERT Pakage (package_name, price, type_in_menu) values(?,?,?)";
    private static final String UPDATE = "UPDATE Pakage SET price=?, number=? WHERE package_name=?";
    private static final String DELETE = "DELETE FROM Pakage WHERE package_name=?";

    @Override
    public int create(PackageModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setString(1, entity.getPackageName());
            preparedStatement.setBigDecimal(2, entity.getPrice());
            preparedStatement.setInt(3, entity.getPackageNumber());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(PackageModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getPackageName());
            preparedStatement.setBigDecimal(2, entity.getPrice());
            preparedStatement.setInt(3, entity.getPackageNumber());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<PackageModel> findAll() throws SQLException {
        List<PackageModel> packages = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    packages.add((PackageModel) new Transformer<>(PackageModel.class).fromResultSetModel(resultSet));
                }
            }
        }
        return packages;
    }

    @Override
    public PackageModel findBy(String s) throws SQLException {
        PackageModel packages = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1, s);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    packages = (PackageModel) new Transformer<>(PackageModel.class).fromResultSetModel(resultSet);
                    break;
                }
            }
        }
        return packages;
    }

    @Override
    public int delete(String s) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setString(1, s);
            return preparedStatement.executeUpdate();
        }
    }
}
