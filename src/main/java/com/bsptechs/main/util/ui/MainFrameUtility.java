/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import com.bsptechs.main.PanelTable;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author sarkhanrasullu
 */
public class MainFrameUtility {

    private static DatabaseDAOInter database = new DatabaseDAOImpl();

    public static void viewTable(JTabbedPane tabQuery, String title) {
        MainFrameUtility.addPanelToTab(tabQuery, new PanelTable(), title);
    }

    public static void addPanelToTab(JTabbedPane tab, JPanel panel, String title) {
        int count = tab.getTabCount();
        tab.addTab(title, panel);
        tab.setSelectedIndex(tab.getTabCount() - 1);
    }

    public static void runQuery() {//eger nese parameter qebul etmesi lazimdirsa deyishiklik et

    }

    public static void onMouseClick_OnTablesList(JFrame frame, JTabbedPane tab, MouseEvent evt) {
        if (MainFrameUtility.isLeftDoubleClicked(evt)) {
            JList listUiDatabases = (JList) evt.getSource();
            UiElement element = (UiElement) listUiDatabases.getSelectedValue();

            System.out.println("element.getData()=" + element.getData());
            if ("table".equals(element.getData())) {
                viewTable(tab, element.getText());
                return;
            }
            List<TableName> list = database.getAllTables(element.getText());

            MainFrameUtility.fillList(list, frame, new UiPopupTable(frame, listUiDatabases, tab), "table", listUiDatabases);

        }
    }

    public static void prepareConnectionsList(JFrame frame, JList uiList) {
        MouseAdapter m = MainFrameUtility.getAdapterForConnectionList(frame, uiList);
        uiList.addMouseListener(m);
    }

    public static void prepareDatabaseList(JFrame frame, JTabbedPane tab, JList list) {
        MouseAdapter m = MainFrameUtility.getAdapterForDatabaseList(frame, tab, list);
        list.addMouseListener(m);
    }

    public static void fillConnectionsIntoJList(JFrame frame, JList uiList) {
        List<NConnection> list = Config.instance().getConnections();
        if(list==null){
            return;
        }
        UiPopupConnection popup = new UiPopupConnection(frame, uiList);
        
        List<String> l = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            l.add(list.get(i).getName());
        }
        MainFrameUtility.fillList(l, frame, popup, null, uiList);
    }

    public static void fillDatabasesIntoJList(JFrame frame, JTabbedPane tab, JList list) {
        List<String> databases = database.getAllDatabases();
       
        UiPopupAbstract popup = new UiPopupDatabase(tab);

        MainFrameUtility.fillList(databases, frame, popup, "database", list);
    }

    public static void fillList(List<?> textList, JFrame frame, JPopupMenu popup, Object data, JList uiList) {
        if(textList==null){
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

    public static MouseAdapter getAdapterForConnectionList(JFrame frame, JList uiList) {
        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MainFrameUtility.showMenuOnList(uiList, evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("I am connection name");
            }
        };
        return m;
    }

    public static MouseAdapter getAdapterForDatabaseList(JFrame frame, JTabbedPane tab, JList list) {
        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                System.out.println("I am released on database list");
                MainFrameUtility.showMenuOnList(list, evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("I am cliecked on database list");
                MainFrameUtility.onMouseClick_OnTablesList(frame, tab, evt);
            }
        };

        return m;
    }

    public static boolean isLeftDoubleClicked(MouseEvent evt) {
        return evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt);
    }
    
    public static void saveConfig(){
         WriteToFileIO.writeObjectToFile(Config.instance(), Config.getFileName());
    }
    
    public static Config readConfig(){
      Object configObj =  ReadFileIO.readFileDeserialize(Config.getFileName());
      if(configObj==null){
          return new Config();
      }else{
          return (Config) configObj;
      }
    }

}