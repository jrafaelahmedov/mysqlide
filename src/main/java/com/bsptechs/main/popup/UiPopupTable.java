/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.util.ui.MainFrameUtility;
import javax.swing.JList;
import javax.swing.JTabbedPane;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupTable extends UiPopupAbstract {

    private JList list;
    private JTabbedPane pane;

    public UiPopupTable(JList list, JTabbedPane pane) {
        this.pane = pane;
        this.list = list;
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
        System.out.println("view table");
        UiElement element = (UiElement) list.getSelectedValue();
        System.out.println("element.getData()=" + element.getData());
        if ("table".equals(element.getData())) {
            MainFrameUtility.viewTable(pane, element.getText());
        }
        //Tebriz burani dolduracaq
    }

    public void renameTable() {
        MainFrameUtility.renameTblClicked(list);
    }
}
