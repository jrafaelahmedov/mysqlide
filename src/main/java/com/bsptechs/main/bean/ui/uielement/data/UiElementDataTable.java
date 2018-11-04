/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.uielement.data;

import com.bsptechs.main.bean.ui.panel.PanelQuery;
import com.bsptechs.main.bean.ui.popup.UiPopupTable;
import java.util.List;
import javax.swing.JPopupMenu;

/**
 *
 * @author Goshgar
 */
public class UiElementDataTable extends UiElementData {

    private String tableName;
    private UiElementDataDatabase databaseName;

    public UiElementDataTable(String tableName, UiElementDataDatabase databaseName) {
        this.tableName = tableName;
        this.databaseName = databaseName;
        setExpanded(true);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public UiElementDataDatabase getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(UiElementDataDatabase databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onDoubleClick() {
        PanelQuery.runQuery("select * from " + this.getTableName());
    }

    @Override
    public JPopupMenu getPopup() {
        return new UiPopupTable();
    }

    @Override
    public List<? extends UiElementData> getSubList() {
        return null;
    }

    @Override
    public String getIcon() {
        return "/icons/table.png";
    }

    @Override
    public String toString() {
        return this.tableName;
    }

}
