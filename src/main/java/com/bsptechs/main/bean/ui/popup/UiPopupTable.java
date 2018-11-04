/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.popup;

import com.bsptechs.main.Main;
import com.bsptechs.main.bean.ui.panel.PanelQuery;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.ui.uielement.data.UiElementDataTable;
import com.bsptechs.main.bean.ui.uielement.UiElement;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupTable extends UiPopupAbstract {

    private static DatabaseDAOInter database = new DatabaseDAOImpl();

    public UiPopupTable() {

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
        Main m = Config.getMain();

        UiElement element = (UiElement) m.getListTable().getSelectionPath().getLastPathComponent();

        if (element.getData() instanceof UiElementDataTable) {
            UiElementDataTable tb = (UiElementDataTable) element.getData();
            PanelQuery.runQuery("select * from " + tb.getTableName());
        }
    }

    public UiElementDataTable getSelectedTable() {
        return (UiElementDataTable) getSelectedElement().getData();
    }

    public void renameTable() {
        UiElementDataTable tb = getSelectedTable();
        String newTblName = (String) JOptionPane.showInputDialog(
                null,
                "Enter new name:",
                "Rename Table",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                tb.getTableName()
        );
        database.renameTable(tb, newTblName);
    }

    private void refreshDB() {
        UiElementDataTable tb = getSelectedTable();
        List<UiElementDataTable> tbNames = database.getAllTables(tb.getDatabaseName());

        Main m = Config.getMain();
    }

    private void emptyTable() {
        UiElementDataTable tb = getSelectedTable();
        database.emptyTable(tb.getDatabaseName(), tb.getTableName());
    }

    private void truncateTeable() {
        UiElementDataTable tb = getSelectedTable();
        database.truncateTable(tb.getDatabaseName(), tb.getTableName());
    }

    private UiElementDataTable selectedElementForCopy;

    private void copyTable() {
        UiElementDataTable tb = getSelectedTable();
        this.selectedElementForCopy = tb;
    }

    private void pasteTable() {
        UiElementDataTable tb = getSelectedTable();

        String newTblName = (String) JOptionPane.showInputDialog(
                null,
                "Enter name:",
                "Paste Table",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                tb.getTableName()
        );

        database.pasteTable(
                selectedElementForCopy.getDatabaseName() + "." + selectedElementForCopy.getTableName(),
                tb.getDatabaseName(),
                newTblName
        );
        refreshDB();
    }

    private void dublicateTable() {
        UiElementDataTable tb = getSelectedTable();
        database.dublicateTable(tb.getDatabaseName(), tb.getTableName());
        refreshDB();
    }

    private void dumpSqlFile() {
    }

    private void objectInformation() {
    }
}
