package com.shtohryn.model.metadata;

public class ForeignKeyMetaData {
    String pkColName;
    String pkTableName;
    String fkColName;

    public String getPkColName(){return pkColName;}

    public void setPkColName(String pkColName){this.fkColName=fkColName;}

    public String getPkTableName(){return pkTableName;}

    public void setPkTableName(String pkTableName){this.pkTableName=pkTableName;}

    public String getFkColName(){return fkColName;}

    public void setFkColName(String fkColName){this.fkColName=fkColName;}

    @Override
    public String toString()
    {
        return "Fk_Col: "+ fkColName + ",  PK_Table: " + pkTableName + ",  PK_Col_Name: " + pkColName;
    }
}
