package com.shtohryn.service;

import com.shtohryn.DAO.implementation.CurlerDAOImpl;
import com.shtohryn.DAO.implementation.UserAccountDAOImpl;
import com.shtohryn.model.entity.CurlerModel;
import com.shtohryn.model.entity.UserAccountModel;
import com.shtohryn.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CurlerService {
    public List<CurlerModel> findAll() throws SQLException {
        return new CurlerDAOImpl().findAll();
    }

    public CurlerModel findById(Integer integer) throws SQLException {
        return new CurlerDAOImpl().findBy(integer);
    }

    public int create(CurlerModel entity) throws SQLException {
        return new CurlerDAOImpl().create(entity);
    }

    public int update(CurlerModel entity) throws SQLException {
        return new CurlerDAOImpl().update(entity);
    }

    public int delete(Integer integer) throws SQLException {
        return new CurlerDAOImpl().delete(integer);
    }

    public int deleteWithMoveOfCustumerTable(Integer idDeleted, Integer idMoveTo) throws SQLException {
        int deletedAmount = 0;
        Connection connection = ConnectionManager.getConnection();
        try {
            connection.setAutoCommit(false);
            if (new CurlerDAOImpl().findBy(idMoveTo) == null)
                throw new SQLException();

            List<UserAccountModel> custumerTable = new UserAccountDAOImpl().findByCurlerNum(idDeleted);
            for (UserAccountModel entity : custumerTable) {
                entity.setAccountId(idMoveTo);
                new UserAccountDAOImpl().update(entity);
            }
            deletedAmount = new UserAccountDAOImpl().delete(idDeleted);
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            }
        } finally {
            connection.setAutoCommit(true);
        }
        return deletedAmount;
    }
}
