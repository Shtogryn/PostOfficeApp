package com.shtohryn.model.entity;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.PrimaryKey;
import com.shtohryn.model.annotation.Table;

@Table(name = "Unit")
public class UnitModel {
    @PrimaryKey
    @Column(name = "unit_name", length = 255)
    private String unitName;

    public UnitModel() {
    }

    public UnitModel(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
