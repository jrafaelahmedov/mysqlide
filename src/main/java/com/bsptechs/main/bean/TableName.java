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
    private DatabaseName databaseName;

    public TableName(String tableName, DatabaseName databaseName) {
        this.tableName = tableName;
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public DatabaseName getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(DatabaseName databaseName) {
        this.databaseName = databaseName;
    }
    
    @Override
    public String toString(){
        return this.tableName;
    }
    
}
