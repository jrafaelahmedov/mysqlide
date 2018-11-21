/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lombok.Data;

/**
 *
 * @author sarkhanrasullu
 */
@Data
public class CustomTable extends JTable {

    private TableData data;

    public void setData(TableData data) {
        DefaultTableModel dtm = new DefaultTableModel(new Vector(data.getRows()), new Vector(data.getColumns()));
        setModel(dtm);
        this.data = data;
    }

    public TableRow getSelectedTableRow() {
        int selectedRowIndex = this.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        TableRow row = (TableRow) model.getDataVector().get(selectedRowIndex);
        return row;
    }

    public List<TableRow> getSelectedTableRows() {
        int[] selectedRowIndexes = this.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        List<TableRow> rows = new ArrayList<>();
        for (int selectedRowIndex : selectedRowIndexes) {
            TableRow row = (TableRow) model.getDataVector().get(selectedRowIndex);
            rows.add(row);
        }
        return rows;
    }
}
