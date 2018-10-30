/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.inter;

import com.bsptechs.main.bean.TableName;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface DatabaseDAOInter {

    List<String> getAllDatabases();

    List<TableName> getAllTables(String databaseName);

    List<String> getAllConnection();

    boolean renameTable(String DBname, String oldTblName, String newTblName);

    boolean emptyTable(String DBName, String tblName);

    boolean truncateTable(String DBName, String tblName);

    boolean dublicateTable();
}
