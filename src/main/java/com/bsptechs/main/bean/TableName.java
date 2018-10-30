/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

/**
 *
 * @author Goshgar
 */
public class TableName {
    private String tableName;
    private String databaseName;

    public TableName(String tableName, String databaseName) {
        this.tableName = tableName;
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    @Override
    public String toString(){
        return this.tableName;
    }
    
}
