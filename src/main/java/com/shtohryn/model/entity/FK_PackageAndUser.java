package com.shtohryn.model.entity;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

@Table(name = "Package_and_User")
public class FK_PackageAndUser {
    @Column(name = "package_name", length = 25)
    private String packageName;
    @Column(name = "id_table")
    private Integer idTable;
    @Column(name = "order_amount", length = 10)
    private String orderAmount;

    public FK_PackageAndUser() {
    }

    public FK_PackageAndUser(String packageName, Integer idTable, String orderAmount) {
        this.packageName = packageName;
        this.idTable = idTable;
        this.orderAmount = orderAmount;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }
}
