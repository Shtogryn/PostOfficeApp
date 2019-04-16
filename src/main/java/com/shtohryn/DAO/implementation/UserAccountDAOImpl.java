package com.shtohryn.DAO.implementation;

import com.shtohryn.DAO.interfaces.UserAccountDAO;
import com.shtohryn.model.entity.UserAccountModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAOImpl implements UserAccountDAO {
    private static final String FIND_BY_WAITER_NUM = "SELECT * FROM User_account WHERE id_waiter=?";
    private static final String FIND_ALL = "SELECT * FROM User_account";
    private static final String DELETE = "DELETE FROM User_account WHERE id_account=?";
    private static final String CREATE = "INSERT User_account (id_account, ordertime, id_curler) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE User_account SET ordertime=?, id_curler=? WHERE id_curler=?";
    private static final String FIND_BY_ID = "SELECT * FROM User_account WHERE id_account=?";

    @Override
    public List<UserAccountModel> findByCurlerNum(Integer curlerNum) throws SQLException {
        return null;
    }

    @Override
    public int create(UserAccountModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getAccountId());
            ps.setTime(2, entity.getOrdertime());
            ps.setInt(3, entity.getCurlerId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(UserAccountModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getAccountId());
            ps.setTime(2, entity.getOrdertime());
            ps.setInt(3, entity.getCurlerId());
            return ps.executeUpdate();
        }
    }

    @Override
    public List<UserAccountModel> findAll() throws SQLException {
        List<UserAccountModel> custumerTable = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet rs = statement.executeQuery(FIND_ALL)){
                while(rs.next()){
                    custumerTable.add((UserAccountModel) new Transformer<>(UserAccountModel.class).fromResultSetModel(rs));
                }
            }
        }
        return custumerTable;
    }

    @Override
    public UserAccountModel findBy(Integer integer) throws SQLException {
        UserAccountModel model = null;
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)){
            ps.setInt(1,integer);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    model=(UserAccountModel) new Transformer<>(UserAccountModel.class).fromResultSetModel(rs);
                    break;
                }
            }
        }
        return model;
    }

    @Override
    public int delete(Integer integer) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE)){
            ps.setInt(1,integer);
            return ps.executeUpdate();
        }
    }
}
