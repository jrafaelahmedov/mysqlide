package com.bsptechs.main.dao.inter;

import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.table.TableData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface DatabaseDAOInter {

    List<String> getAllDatabases();

    List<TableName> getAllTables(String databaseName);

    boolean renameTable(String DBname, String oldTblName, String newTblName);

    public TableData runQuery(String query) throws ClassNotFoundException, SQLException;
}
