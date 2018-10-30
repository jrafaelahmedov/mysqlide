/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import com.bsptechs.main.util.ui.MainFrameUtility;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupTable extends UiPopupAbstract {

    private static DatabaseDAOInter database = new DatabaseDAOImpl();

    private JList list;
    private JTabbedPane pane;
    private JFrame frame;

    public UiPopupTable(JFrame frame, JList list, JTabbedPane pane) {
        this.pane = pane;
        this.list = list;
        this.frame = frame;
        addMenuItem("Delete Table", () -> {
            delete();
        });
        addMenuItem("Table Properties", () -> {
            properties();
        });

        addMenuItem("New Query", () -> {
            newQuery();
        });

        addMenuItem("View Table", () -> {
            viewTable();
        });
        addMenuItem("Rename", () -> {
            renameTable();
        });
        addMenuItem("Refresh", () -> {
            refreshDB();
        });
        addMenuItem("Empty Table", () -> {
            emptyTable();
        });
        addMenuItem("Truncate Table", () -> {
            truncateTeable();
        });
        addMenuItem("Copy", () -> {
            copyTable();
        });
        addMenuItem("Paste", () -> {
            pasteTable();
        });
        addMenuItem("Dublicate Table", () -> {
            dublicateTable();
        });
        addMenuItem("Dump Sql file", () -> {
            dumpSqlFile();
        });
        addMenuItem("Object Information", () -> {
            objectInformation();
        });

    }

    public void delete() {
        System.out.println("table delete");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("table properties");
        //Tebriz burani dolduracaq
    }

    public void newQuery() {
        System.out.println("new query");
        //Tebriz burani dolduracaq
    }

    public void viewTable() {
        System.out.println("view table");
        UiElement element = (UiElement) list.getSelectedValue();
        System.out.println("element.getData()=" + element.getData());
        if ("table".equals(element.getData())) {
            MainFrameUtility.viewTable(pane, element.getText());
        }
        //Tebriz burani dolduracaq
    }

    public void renameTable() {
        int selectedIndex = list.getSelectedIndex();
        UiElement selectedElement = (UiElement) list.getModel().getElementAt(selectedIndex);
        TableName tb = (TableName) selectedElement.getData();
        String newTblName = (String) JOptionPane.showInputDialog(null, "Enter new name:", "Rename Table",
                JOptionPane.QUESTION_MESSAGE, null, null, tb.getTableName());
        database.renameTable(tb.getDatabaseName(), tb.getTableName(), newTblName);
        List<TableName> tbNames = database.getAllTables(tb.getDatabaseName());
        MainFrameUtility.fillList(tbNames, frame, new UiPopupTable(frame, list, pane), "table", list);
    }

    private void refreshDB() {
        int selectedIndex = list.getSelectedIndex();
        UiElement selectedElement = (UiElement) list.getModel().getElementAt(selectedIndex);
        TableName tb = (TableName) selectedElement.getData();
        List<TableName> tbNames = database.getAllTables(tb.getDatabaseName());
        MainFrameUtility.fillList(tbNames, frame, new UiPopupTable(frame, list, pane), "table", list);
    }

    private void emptyTable() {
        int selectedIndex = list.getSelectedIndex();
        UiElement selectedElement = (UiElement) list.getModel().getElementAt(selectedIndex);
        TableName tb = (TableName) selectedElement.getData();
        database.emptyTable(tb.getDatabaseName(), tb.getTableName());
    }

    private void truncateTeable() {
        int selectedIndex = list.getSelectedIndex();
        UiElement selectedElement = (UiElement) list.getModel().getElementAt(selectedIndex);
        TableName tb = (TableName) selectedElement.getData();
        database.truncateTable(tb.getDatabaseName(), tb.getTableName());
    }

    private void copyTable() {
    }

    private void pasteTable() {
    }

    private void dublicateTable() {
    }

    private void dumpSqlFile() {
    }

    private void objectInformation() {
    }
}
