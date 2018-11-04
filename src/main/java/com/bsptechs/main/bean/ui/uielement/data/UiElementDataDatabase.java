package com.bsptechs.main.bean.ui.uielement.data;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.ui.popup.UiPopupDatabase;
import java.util.List;
import javax.swing.JPopupMenu;

public class UiElementDataDatabase extends UiElementData {

    private String name;
    private UiElementDataConnection connection;
    private List<UiElementDataTable> tables;

    public UiElementDataDatabase() {
    }

    public UiElementDataDatabase(String name, UiElementDataConnection connection) {
        this.name = name;
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UiElementDataConnection getConnection() {
        return connection;
    }

    public void setConnection(UiElementDataConnection connection) {
        this.connection = connection;
    }

    public List<UiElementDataTable> getTables() {
        return tables;
    }

    public void setTables(List<UiElementDataTable> tables) {
        this.tables = tables;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onDoubleClick() {
        Config.setCurrentDatabaseName(this);
        if (tables == null) {
            tables = database.getAllTables(this);
            Config.getMain().getListTable().fillTree(tables, Config.getMain().getListTable().getSelectedNode());
            setExpanded(true);
        }
    }

    @Override
    public JPopupMenu getPopup() {
        return new UiPopupDatabase();
    }

    @Override
    public List<UiElementDataTable> getSubList() {
        return getTables();
    }

    @Override
    public String getIcon() {
        return "/icons/database.png";
    }

    @Override
    public String toString() {
        return name;
    }

}
