package com.bsptechs.main.dao.inter;

import com.bsptechs.main.bean.ui.uielement.data.UiElementDataDatabase;
import com.bsptechs.main.bean.ui.uielement.data.UiElementDataConnection;
import com.bsptechs.main.bean.ui.uielement.data.UiElementDataTable;
import com.bsptechs.main.bean.ui.table.TableData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface DatabaseDAOInter {

    List<UiElementDataDatabase> getAllDatabases(UiElementDataConnection connection);

    List<UiElementDataTable> getAllTables(UiElementDataDatabase database);

    boolean emptyTable(UiElementDataDatabase db, String tblName);

    boolean truncateTable(UiElementDataDatabase DBName, String tblName);

    boolean dublicateTable(UiElementDataDatabase DBName, String tbLName);

    boolean pasteTable(String information, UiElementDataDatabase DBName, String tbLName);

    boolean renameTable(UiElementDataTable table, String newTblName);

    public TableData runQuery(String query, UiElementDataConnection connection, UiElementDataDatabase database) throws ClassNotFoundException, SQLException;

}
