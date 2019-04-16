package com.shtohryn.DAO.interfaces;

import com.shtohryn.model.entity.UserAccountModel;

import java.sql.SQLException;
import java.util.List;

public interface UserAccountDAO extends GeneralDAO<UserAccountModel, Integer> {
    List<UserAccountModel> findByCurlerNum(Integer curlerNum) throws SQLException;
}
