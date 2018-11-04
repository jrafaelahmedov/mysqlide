/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.PanelQuery;
import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.popup.file.FileUtility;
import com.bsptechs.main.util.ui.MainFrameUtility;
import static java.util.Collections.list;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.DatabaseName;
import com.bsptechs.main.util.ui.MainFrameUtility;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupDatabase extends UiPopupAbstract {

    DatabaseDAOImpl database = new DatabaseDAOImpl();

    JList list;

    public UiPopupDatabase() {
        addMenuItem("Database Properties", () -> {
            properties();
        });
        addMenuItem("Delete Database", () -> {
            delete();
        });
        addMenuItem("New Query", () -> {
            try {
                newQuery();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UiPopupDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UiPopupDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public void delete() {
        System.out.println("delete database");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("properites database");
        //Tebriz burani dolduracaq
    }

    public void newQuery() throws ClassNotFoundException, SQLException {
        System.out.println("new query");
        DatabaseName db = Config.getCurrentDatabaseName();
        MainFrameUtility.addPanelToTab(Config.getMain().getTabPaneTable(), new PanelQuery(null, db), "Query");
    }

}
