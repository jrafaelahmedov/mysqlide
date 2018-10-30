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

    boolean renameTable(String DBname,String oldTblName, String newTblName);

}
