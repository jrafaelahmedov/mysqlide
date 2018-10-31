/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import com.bsptechs.main.FrameMysqlConnection;
import com.bsptechs.main.Main;
import com.bsptechs.main.PanelTable;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.bean.table.TableCell;
import com.bsptechs.main.bean.table.TableRow;
import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.bean.table.TableData;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.dao.inter.AbstractDatabase;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import com.bsptechs.main.popup.UiPopupAbstract;
import com.bsptechs.main.popup.UiPopupConnection;
import com.bsptechs.main.popup.UiPopupDatabase;
import com.bsptechs.main.popup.UiPopupTable;
import com.bsptechs.main.util.file.ReadFileIO;
import com.bsptechs.main.util.file.WriteToFileIO;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author sarkhanrasullu
 */
public class MainFrameUtility extends AbstractDatabase {

    public static List<String> columname = new ArrayList<>();

    private static DatabaseDAOInter database = new DatabaseDAOImpl();

    public static void viewTable(JTabbedPane tabQuery, String title) {
        MainFrameUtility.addPanelToTab(tabQuery, new PanelTable(), title);
    }

    public static void addPanelToTab(JTabbedPane tab, JPanel panel, String title) {
        int count = tab.getTabCount();
        tab.addTab(title, panel);
        tab.setSelectedIndex(tab.getTabCount() - 1);
    }

    public static void fillTableToRunnedQuery() {

    }

  
     

    public static void onMouseClick_OnTablesList(MouseEvent evt) {
        if (MainFrameUtility.isLeftDoubleClicked(evt)) {
            JList listUiDatabases = Config.getMain().getListTable();
            UiElement element = (UiElement) listUiDatabases.getSelectedValue();

            if ("table".equals(element.getData())) {
                viewTable(Config.getMain().getTabPaneTable(), element.getText());
                return;
            }
            List<TableName> list = database.getAllTables(element.getText());

            MainFrameUtility.fillList(list, Config.getMain(), new UiPopupTable(), "table", listUiDatabases);

        }
    }

    public static void prepareConnectionsList() {
        MouseAdapter m = MainFrameUtility.getAdapterForConnectionList();
        Config.getMain().getListConnections().addMouseListener(m);
    }

    public static void prepareDatabaseList() {
        MouseAdapter ma = MainFrameUtility.getAdapterForDatabaseList();
        Main m = Config.getMain();
        JList listTable = m.getListTable();
        listTable.addMouseListener(ma);
    }

    public static void showFrameForMySQLConnection(JFrame frame, JTabbedPane tab, JList listConnections, JList listDatabases) {

        new FrameMysqlConnection().setVisible(true);
        MainFrameUtility.fillConnectionsIntoJList();

    }

    public static void fillConnectionsIntoJList() {
        Main m = Config.getMain();
        List<NConnection> list = Config.instance().getConnections();
        if (list == null) {
            return;
        }
        UiPopupConnection popup = new UiPopupConnection();

        List<String> l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            l.add(list.get(i).getName());
        }
        MainFrameUtility.fillList(l, m, popup, null, m.getListConnections());
    }

    public static void fillDatabasesIntoJList() {
        List<String> databases = database.getAllDatabases();

        UiPopupAbstract popup = new UiPopupDatabase();
        Main m = Config.getMain();
        MainFrameUtility.fillList(databases, m, popup, "database", m.getListTable());
    }

    public static void fillList(List<?> textList, JFrame frame, JPopupMenu popup, Object data, JList uiList) {
        if (textList == null) {
            return;
        }
        DefaultListModel dm = new DefaultListModel();
        for (Object t : textList) {
            UiElement uiElement = new UiElement(t.toString());
            uiElement.setFrame(frame);
            uiElement.setPopup(popup);
            uiElement.setData(t);
            dm.addElement(uiElement);
        }

        uiList.setModel(dm);
    }

    public static UiElement getUiElementFromList(JList list) {
        return (UiElement) list.getModel().getElementAt(list.getSelectedIndex());
    }

    public static void showMenuOnList(JList list, MouseEvent evt) {
        if (list.getSelectedIndex() > -1 && SwingUtilities.isRightMouseButton(evt)) {
            UiElement element = (UiElement) list.getModel().getElementAt(list.getSelectedIndex());
            int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
            element.getPopup().show(element.getFrame(), mouseX, mouseY - 5);
        }
    }

    public static MouseAdapter getAdapterForConnectionList() {
        Main main = Config.getMain();

        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MainFrameUtility.showMenuOnList(main.getListConnections(), evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("I am connection name");
                MainFrameUtility.onMouseClick_OnConnectionsList(evt);
            }
        };
        return m;
    }

    public static MouseAdapter getAdapterForDatabaseList() {
        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                System.out.println("I am released on database list");
                MainFrameUtility.showMenuOnList(Config.getMain().getListTable(), evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("I am cliecked on database list");
                MainFrameUtility.onMouseClick_OnTablesList(evt);
            }
        };

        return m;
    }

    public static boolean isLeftDoubleClicked(MouseEvent evt) {
        return evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt);
    }

    public static void saveConfig() {
        WriteToFileIO.writeObjectToFile(Config.instance(), Config.getFileName());
    }

    public static Config readConfig() {
        Object configObj = ReadFileIO.readFileDeserialize(Config.getFileName());
        if (configObj == null) {
            return new Config();
        } else {
            return (Config) configObj;
        }
    }

    public static void onMouseClick_OnConnectionsList(MouseEvent evt) {
        if (MainFrameUtility.isLeftDoubleClicked(evt)) {
            connect();
        }
    }

    public static void connect() {
        Main m = Config.getMain();
        int index = m.getListConnections().getSelectedIndex();
        System.out.println("selected index=" + index);
        NConnection selectedConnection = Config.instance().getConnections().get(index);
        Config.setConnection(selectedConnection);
        MainFrameUtility.fillDatabasesIntoJList();
    }

    public static void disconnect() {
        try {
            NConnection connection = getSelectedConnectionFromList();
            if (connection.getParentConnection() != null) {
                connection.getParentConnection().close();
            }
            if (Config.getCurrentConnection() == connection) {
                Config.getMain().getListTable().setModel(new DefaultListModel());
            }
            connection.setParentConnection(null);
            System.out.println(connection.getName() + " connection is closed");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showMySQLConnectionAsUpdate() {
        FrameMysqlConnection f = new FrameMysqlConnection();
        f.showAsUpdate();
    }

    public static NConnection getSelectedConnectionFromList() {
        Main m = Config.getMain();

        int index = m.getListConnections().getSelectedIndex();
        System.out.println("selected index=" + index);
        NConnection selectedConnection = Config.instance().getConnections().get(index);
        return selectedConnection;
    }

    public static int getSelectedConnectionIndexFromList() {
        int index = Config.instance().getConnections().indexOf(getSelectedConnectionFromList());
        return index;
    }

}
