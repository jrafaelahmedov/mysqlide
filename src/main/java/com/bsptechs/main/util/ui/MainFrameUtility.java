/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;
 
import com.bsptechs.main.Main;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.DatabaseName;
import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import com.bsptechs.main.popup.UiPopupConnection;
import com.bsptechs.main.popup.UiPopupDatabase;
import com.bsptechs.main.popup.UiPopupTable;
import com.bsptechs.main.util.file.ReadFileIO;
import com.bsptechs.main.util.file.WriteToFileIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author sarkhanrasullu
 */
public class MainFrameUtility {

    public static List<String> columname = new ArrayList<>();

    private static DatabaseDAOInter database = new DatabaseDAOImpl();

    public static void addPanelToTab(JTabbedPane tab, JPanel panel, String title) {
        int count = tab.getTabCount();
        tab.addTab(title, panel);
        tab.setSelectedIndex(tab.getTabCount() - 1);
    }

    public static void onMouseClick_OnTablesList(MouseEvent evt) {
        if (MainFrameUtility.isLeftDoubleClicked(evt)) {

            UiElement element = Util.getUiElementFromList(Config.getMain().getListTable());
            System.out.println("element.getData()=" + element.getData());
            if (element.getData() instanceof TableName) {
                TableName tb = (TableName) element.getData();
                PanelQueryUtil.runQuery("select * from " + tb.getTableName());
                return;
            }

            if (element.getData() instanceof DatabaseName) {
                DatabaseName db = (DatabaseName) element.getData();
                Config.setCurrentDatabaseName(db);
                List<TableName> list = database.getAllTables(db);

                MainFrameUtility.fillTree(list, Config.getMain(), new UiPopupTable(), null, Config.getMain().getListTable());
            }
        }
    }

    public static void prepareList() {
        MouseAdapter ma = MainFrameUtility.getAdapterForList();
        JTree listTable = Config.getMain().getListTable();
        listTable.addMouseListener(ma);
    }

    public static void centralizeJFrame(JFrame frame) {
        frame.setSize(220, 400);
        frame.setLocationRelativeTo(null);
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    public static void fillConnectionsIntoJList() {
        Main m = Config.getMain();
        List<NConnection> list = Config.instance().getConnections();

        if (list == null) {
            return;
        }

        MainFrameUtility.fillTree(list, m, new UiPopupConnection(), null, m.getListTable());
    }

    public static void fillDatabasesIntoJList(NConnection connection) {

        Main m = Config.getMain();
        MainFrameUtility.fillTree(connection.getDatabases(), m, new UiPopupDatabase(), "database", m.getListTable());
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

    public static void fillConnections(List<NConnection> list, JFrame frame, JPopupMenu popup, Object data, JTree tree) {
        if (list == null) {
            return;
        }
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        DefaultMutableTreeNode dm = new DefaultMutableTreeNode();
        for (NConnection t : list) {
            UiElement uiElement = new UiElement(t.toString());
            uiElement.setFrame(frame);
            uiElement.setPopup(popup);
            uiElement.setData(t);

            model.insertNodeInto(new DefaultMutableTreeNode(uiElement), root, root.getChildCount());
        }

    }

    public static void fillTree(List<?> textList, JFrame frame, JPopupMenu popup, Object data, JTree tree) {
        if (textList == null) {
            return;
        }

        for (Object t : textList) {
            UiElement uiElement = new UiElement(t.toString());
            uiElement.setFrame(frame);
            uiElement.setPopup(popup);
            uiElement.setData(t);

            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
            if (Util.getSelectedNode(tree) != null) {
                root = Util.getSelectedNode(tree);
            }
            model.insertNodeInto(new DefaultMutableTreeNode(uiElement), root, root.getChildCount());
        }

    }

    
   
    public static MouseAdapter getAdapterForList() {
        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                System.out.println("I am released on database list");
                Util.showMenuOnList(Config.getMain().getListTable(), evt);
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
    
    public static boolean isRightClicked(MouseEvent evt) {
        return SwingUtilities.isRightMouseButton(evt);
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
            NConnection selectedConnection = getSelectedConnectionFromList();
            Config.setCurrentConnection(selectedConnection);
            connect(selectedConnection);
            Config.getMain().enableNewQuery();
        }
    }

    public static void connect(NConnection connection) {
        List<DatabaseName> databases = database.getAllDatabases(connection);
        connection.setDatabases(databases);
        MainFrameUtility.fillDatabasesIntoJList(connection);

    }

    public static void disconnect() {
        NConnection connection = Config.getCurrentConnection();
        connection.reset();
        System.out.println(connection.getName() + " connection is closed");
    }

    public static NConnection getSelectedConnectionFromList() {
        Main m = Config.getMain();
        UiElement uiElement = Util.getUiElementFromList(m.getListTable());
        if (uiElement == null) {
            return null;
        }
        NConnection selectedConnection = (NConnection) uiElement.getData();
        return selectedConnection;
    }

    public static DatabaseName getSelectedDatabaseFromList() {
        Main m = Config.getMain();
        UiElement uiElement = Util.getUiElementFromList(m.getListTable());
        if (uiElement == null) {
            return null;
        }
        Object obj = uiElement.getData();
        if (obj instanceof DatabaseName) {
            return (DatabaseName) obj;
        }
        return null;
    }

    public static TableName getSelectedTableFromList() {
        Main m = Config.getMain();
        UiElement uiElement = Util.getUiElementFromList(m.getListTable());
        if (uiElement == null) {
            return null;
        }
        Object obj = uiElement.getData();
        if (obj instanceof TableName) {
            return (TableName) obj;
        }
        return null;
    }

    public static int getSelectedConnectionIndexFromList() {
//        int index = Config.getMain().getListTable().getSelectedIndex();
//        return index;
        return -1;
    }



   
}
