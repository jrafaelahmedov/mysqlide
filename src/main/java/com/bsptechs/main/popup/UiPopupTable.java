/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.PanelTable;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.service.UiService;
import com.bsptechs.main.service.UiServiceTabbedPane;
import com.bsptechs.main.util.ui.UiUtil;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupTable extends UiPopupAbstract {

    private JList list;
    
    public UiPopupTable(JList list){
        this.list = list;
    }
    
    
    @Override
    public JPopupMenu popup() {
        JMenuItem itemDelete = menuItem("Delete Table");
        JMenuItem itemProperties = menuItem("Table Properties");
        JMenuItem itemNewQuery = menuItem("New Query");
        JMenuItem itemViewTable = menuItem("View Table");

        addActionListener(itemProperties, () -> {
            properties();
        });
        addActionListener(itemDelete, () -> {
            delete();
        });
        addActionListener(itemNewQuery, () -> {
            newQuery();
        });
        addActionListener(itemViewTable, () -> {
            viewTable();
        });
        return this;
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
        UiServiceTabbedPane tabPanelTableService = (UiServiceTabbedPane) UiService.getUiService("tabTable");
        
        UiElement element = UiUtil.getUiElement(list);
        String tableName = element.getText();
        tabPanelTableService.addPanelToTab(new PanelTable(tableName), tableName);
    }

}
