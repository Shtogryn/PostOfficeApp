package com.shtohryn.model.metadata;

import java.util.ArrayList;
import java.util.List;

public class TableMetaData {
    String DBName;
    String tableName;
    List<ColumnMetaData> colMetaData = new ArrayList<ColumnMetaData>();
    private List<ForeignKeyMetaData> fkList = new ArrayList<ForeignKeyMetaData>();

    public String getDBName(){return DBName;}

    public void setDBName(String DBName){this.DBName=DBName;}

    public String getTableName(){return tableName;}

    public void setTableName(String tableName){this.tableName=tableName;}

    public List<ColumnMetaData> getColumnMetaData() {
        return colMetaData;
    }

    public void setColumnMetaData(List<ColumnMetaData> columnMetaData) {
        this.colMetaData = columnMetaData;
    }

    public List<ForeignKeyMetaData> getForeignKeyList() {
        return fkList;
    }

    public void setForeignKeyList(List<ForeignKeyMetaData> fkList) {
        this.fkList = fkList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Table: "+tableName+"\n");
        for (ColumnMetaData column : colMetaData) {
            stringBuilder.append(column+"\n");
        }
        for(ForeignKeyMetaData fk : fkList){
            stringBuilder.append(fk+"\n");
        }
        return stringBuilder.toString();
    }
}
