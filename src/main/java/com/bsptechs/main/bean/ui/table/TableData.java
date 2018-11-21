/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.table;

import java.util.List;
import java.util.List;
import lombok.Data;

/**
 *
 * @author sarkhanrasullu
 */
@Data
public class TableData {

    private String databaseName;
    private String tableName;
    private List<TableRow> rows;
    private List<String> columns;

    public TableData(List<TableRow> rows, List<String> columns,String databaseName, String tableName){
        this.rows = rows;
        this.columns = columns;
        this.tableName = tableName;
        this.databaseName = databaseName;
    }
}
