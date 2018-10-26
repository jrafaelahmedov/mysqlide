/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.PanelQuery;
import com.bsptechs.main.util.ui.MainFrameUtility;
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
            newQuery();
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

    public void newQuery() {
        System.out.println("new query");
        MainFrameUtility.addPanelToTab(pane, new PanelQuery(), "Query");
    }

}
