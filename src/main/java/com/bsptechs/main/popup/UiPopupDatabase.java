/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.PanelQuery;
import com.bsptechs.main.util.ui.MainFrameUtility;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupDatabase extends UiPopupAbstract {

    JTabbedPane pane;

    public UiPopupDatabase(JTabbedPane pane) {
        this.pane = pane;
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
        MainFrameUtility.addPanelToTab(pane, new PanelQuery(), "Query");
    }

}
