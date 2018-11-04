/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.uielement.data;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.ui.popup.UiPopupConnection;
import com.bsptechs.main.bean.ui.tree.CustomJTree;
import com.bsptechs.main.bean.ui.uielement.UiElement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPopupMenu;

/**
 *
 * @author Penthos
 */
public class UiElementDataConnection extends UiElementData implements Serializable {

    private String name;
    private String ipAdr;
    private String port;
    private String userName;
    private String password;
    private transient Connection parentConnection;
    private transient List<UiElementDataDatabase> databases;

    public UiElementDataConnection() {
    }

    public UiElementDataConnection(String name, String ipAdr, String port, String userName, String password) {
        this.name = name;
        this.ipAdr = ipAdr;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public List<UiElementDataDatabase> getDatabases() {
        return databases;
    }

    public void setDatabases(List<UiElementDataDatabase> databases) {
        this.databases = databases;
    }

    public String getIpAdr() {
        return ipAdr;
    }

    public void setIpAdr(String ipAdr) {
        this.ipAdr = ipAdr;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection getParentConnection() {
        return parentConnection;
    }

    public void setParentConnection(Connection parentConnection) {
        this.parentConnection = parentConnection;
    }

    public void reset() {
        try {
            this.parentConnection.close();
            this.parentConnection = null;
            this.databases = null;
            Config.getMain().refreshNewQuery();
            Config.getMain().getListTable().refresh();
        } catch (SQLException ex) {
            Logger.getLogger(UiElementDataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        if (databases == null) {
            databases = database.getAllDatabases(this);
            Config.setCurrentConnection(this);
            Config.getMain().getListTable().fillTree(databases, Config.getMain().getListTable().getSelectedNode());
            Config.getMain().refreshNewQuery();
            setExpanded(true);
        }
    }

    @Override
    public void onClick() {
    }

    @Override
    public void onDoubleClick() {
        connect();
    }

    @Override
    public JPopupMenu getPopup() {
        return new UiPopupConnection();
    }

    @Override
    public List<UiElementDataDatabase> getSubList() {
        return getDatabases();
    }

    @Override
    public String getIcon() {
        return "/icons/connection.png";
    }

    @Override
    public String toString() {
        return name;
    }

}
