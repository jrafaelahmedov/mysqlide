package com.bsptechs.main.dao.inter;

import com.bsptechs.main.bean.Charset;
import com.bsptechs.main.bean.Collation;
import com.bsptechs.main.bean.ui.uielement.UiElementDatabase;
import com.bsptechs.main.bean.ui.uielement.UiElementConnection;
import com.bsptechs.main.bean.ui.uielement.UiElementTable;
import com.bsptechs.main.bean.ui.table.TableData;
import com.bsptechs.main.bean.ui.table.TableRow;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface DatabaseDAOInter {

    List<UiElementDatabase> getAllDatabases(UiElementConnection connection);

    List<UiElementTable> getAllTables(UiElementDatabase database);

    boolean emptyTable(UiElementDatabase db, String tblName);

    boolean truncateTable(UiElementDatabase DBName, String tblName);

    boolean dublicateTable(UiElementDatabase DBName, String tbLName);

    boolean pasteTable(String information, UiElementDatabase DBName, String tbLName);
    
    boolean createTable(String[] information, UiElementDatabase DBName, String tbLName);

    boolean renameTable(UiElementTable table, String newTblName);

    public TableData runQuery(String query, UiElementConnection connection, UiElementDatabase database) throws Exception;

    public boolean createDb(UiElementConnection ui, String name, String charset, String collate);

    public List<Charset> getAllCharsets(UiElementConnection connection);

    public List<Collation> getAllCollations(UiElementConnection connection, Charset charset);

    public boolean deleteRow(UiElementConnection connection, TableRow row);

    public boolean deleteRows(UiElementConnection connection, List<TableRow> rows);

}
