/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import com.bsptechs.main.service.popup.UiServicePopupAbstract;
import com.bsptechs.main.service.popup.UiServicePopupDatabase;
import com.bsptechs.main.service.popup.UiServicePopupTable;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.DatabaseDAOImpl;
import com.bsptechs.main.dao.DatabaseDAOInter;
import com.bsptechs.main.util.ui.UiUtil;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServiceMain {

    private DatabaseDAOInter database = new DatabaseDAOImpl();
    private JFrame frame = null;

    public UiServiceMain(JFrame frame) {
        this.frame = frame;
    }

    public void fillTablesIntoJList(MouseEvent evt) {
        if (UiUtil.isDoubleClicked(evt) & SwingUtilities.isLeftMouseButton(evt)) {
            JList listUiDatabases = (JList) evt.getSource();
            UiElement element = (UiElement) listUiDatabases.getSelectedValue();
            List<String> list = database.getAllTables(element.getText());
            UiUtil.fillList(list, frame, popupOnTables(), listUiDatabases);
        }
    }

    public void fillDatabasesIntoJList(JList databaseJList) {
        List<String> databases = database.getAllDatabases();
        UiUtil.fillList(databases, frame, popupOnDatabase(), databaseJList);
    }
 
    private JPopupMenu popupOnTables() {
        JPopupMenu popup = new JPopupMenu();
        UiServicePopupAbstract popupAction = new UiServicePopupTable(frame, popup);
        JMenuItem itemDelete = new JMenuItem("Delete Table");
        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAction.delete();
            }
        });

        JMenuItem itemProperties = new JMenuItem("Table Properties");
        itemProperties.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAction.properties();
            }
        });

        popup.add(itemDelete);
        popup.add(itemProperties);
        return popup;
    }

    private JPopupMenu popupOnDatabase() {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem itemDelete = new JMenuItem("Delete Database");
        JMenuItem itemProperties = new JMenuItem("Database Properties");
        JMenuItem itemNewQuery = new JMenuItem("New Query");
        UiServicePopupDatabase popupAction = new UiServicePopupDatabase(frame, popup);

        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAction.delete();
            }
        });

        itemProperties.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAction.properties();
            }
        });
        
        itemNewQuery.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAction.newQuery();
            }
        });

        popup.add(itemDelete);
        popup.add(itemProperties);
        return popup;
    }

}
