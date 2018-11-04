/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.table.TableData;
import com.bsptechs.main.bean.table.TableRow;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sarkhanrasullu
 */
public class PanelQueryUtil {
     public static void runQuery(String txt) {
        Config.getMain().prepareNewQuery();
        Config.getMain().getPanelQuery().setQuery(txt);
        Config.getMain().getPanelQuery().runQuery();
    }

     
         public static DefaultTableModel buildTableModel(TableData tableData) {
        Vector<String> columnNames = new Vector<String>(tableData.getColumns());

        Vector<Vector<Object>> rowsVector = new Vector<Vector<Object>>();
        List<TableRow> rows = tableData.getRows();
        for (TableRow row : rows) {
            Vector<Object> vector = new Vector<Object>(row.getCells());
            rowsVector.add(vector);
        }

        DefaultTableModel dtm = new DefaultTableModel(rowsVector, columnNames);
        return dtm;
    }
}
