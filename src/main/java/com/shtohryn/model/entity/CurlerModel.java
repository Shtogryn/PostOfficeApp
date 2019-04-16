package com.shtohryn.model.entity;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

@Table(name = "Curler")
public class CurlerModel {
    @Column(name = "id_curler", length = 11)
    private Integer curlerId;
    @Column(name = "name", length = 10)
    private String nameCurler;
    @Column(name = "lastname", length = 10)
    private String lastNameCurler;

    public CurlerModel() {
    }

    public Integer getCurlerId() {
        return curlerId;
    }

    public void setCurlerId(Integer curlerId) {
        this.curlerId = curlerId;
    }

    public String getNameCurler() {
        return nameCurler;
    }

    public void setNameCurler(String nameCurler) {
        this.nameCurler = nameCurler;
    }

    public String getLastNameCurler() {
        return lastNameCurler;
    }

    public void setLastNameCurler(String lastNameCurler) {
        this.lastNameCurler = lastNameCurler;
    }

    public CurlerModel(Integer curlerId, String nameCurler, String lastNameCurler) {
        this.curlerId = curlerId;
        this.nameCurler = nameCurler;
        this.lastNameCurler = lastNameCurler;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-7s  %-7s",curlerId ,nameCurler,lastNameCurler);
    }
}
