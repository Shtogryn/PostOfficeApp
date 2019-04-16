package com.shtohryn.model.metadata;

public class ColumnMetaData {

    private String colName;
    private String dataType;
    private String colSize;
    private String decimalDigits;
    private boolean isNull;
    private boolean isAutoIncrement;
    private boolean isPrKey;

    public String getColName() { return colName; }

    public void setColName(String colName) { this.colName=colName; }

    public String getDataType(){return dataType;}

    public void setDataType(String dataType){this.dataType=dataType;}

    public String getColSize(){return colSize;}

    public void setColSize(String colSize){this.colSize=colSize;}

    public  String getDecimalDigits(){return decimalDigits;}

    public  void setDecimalDigits(String decimalDigits){this.decimalDigits=decimalDigits;}

    public boolean isNull(){return isNull;}

    public void setNull(boolean nulll){isNull = nulll;}

    public boolean isAutoIncrement(){return isAutoIncrement;}

    public void setAutoIncrement(boolean autoIncrement){isAutoIncrement=autoIncrement;}

    public boolean isPrKey(){return isPrKey;}

    public void setPrKey(boolean prKey){isPrKey=prKey;}

    @Override
    public String toString (){
        String str = String.format("%-15s  %-12s  %-8s  %s  %s",
        colName,
                dataType + "(" + colSize + ")",
                (isNull ? "NULL" : "NOT NULL"),
                (isPrKey ? "PK" : ""),
                (isAutoIncrement ? "  AutoIncrement" : ""));
        return str;
    }
}
