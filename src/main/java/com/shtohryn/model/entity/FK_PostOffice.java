package com.shtohryn.model.entity;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

@Table(name = "Post_office")
public class FK_PostOffice {
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "unit_name")
    private String unitName;
    @Column(name = "number")
    private Integer number;

    public FK_PostOffice() {
    }

    public FK_PostOffice(String packageName, String unitName, Integer number) {
        this.packageName = packageName;
        this.unitName = unitName;
        this.number = number;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-5s %-5s", packageName, unitName, number);
    }
}
