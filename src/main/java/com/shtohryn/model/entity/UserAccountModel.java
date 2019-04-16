package com.shtohryn.model.entity;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

import java.sql.Time;

@Table(name = "User_account")
public class UserAccountModel {
    @Column(name = "id_account", length = 11)
    private Integer AccountId;
    @Column(name = "ordertime", length = 15)
    private Time ordertime;
    @Column(name = "id_curler", length = 11)
    private Integer curlerId;

    public UserAccountModel() {
    }

    public UserAccountModel(Integer accountId, Time ordertime, Integer curlerId) {
        AccountId = accountId;
        this.ordertime = ordertime;
        this.curlerId = curlerId;
    }

    public Integer getAccountId() {
        return AccountId;
    }

    public void setAccountId(Integer accountId) {
        AccountId = accountId;
    }

    public Time getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Time ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getCurlerId() {
        return curlerId;
    }

    public void setCurlerId(Integer curlerId) {
        this.curlerId = curlerId;
    }
}
