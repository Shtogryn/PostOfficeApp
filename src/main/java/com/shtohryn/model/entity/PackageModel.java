package com.shtohryn.model.entity;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.PrimaryKey;
import com.shtohryn.model.annotation.Table;

import java.math.BigDecimal;

@Table(name = "Package")
public class PackageModel {
    @PrimaryKey
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "package_number")
    private Integer packageNumber;

    public PackageModel() {
    }

    public PackageModel(String packageName, BigDecimal price, Integer packageNumber) {
        this.packageName = packageName;
        this.price = price;
        this.packageNumber = packageNumber;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    @Override
    public String toString() {
        return String.format("%-5s %4.5f  %s", packageName, price, packageNumber);
    }
}
