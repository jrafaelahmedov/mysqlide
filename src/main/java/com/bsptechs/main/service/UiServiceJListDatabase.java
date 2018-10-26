/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import com.bsptechs.main.popup.UiPopupAbstract;
import com.bsptechs.main.popup.UiPopupDatabase;
import com.bsptechs.main.popup.UiPopupTable;
import com.bsptechs.main.util.ui.UiUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServiceJListDatabase extends UiServiceJList {

    private DatabaseDAOInter database = new DatabaseDAOImpl();

    public UiServiceJListDatabase(String serviceName, JFrame frame, JList list) {
        super(serviceName, frame, list);//
    }

    @Override
    public List<String> getItems() {
        database = new DatabaseDAOImpl();
        List<String> databases = database.getAllDatabases();
        return databases;
    }

    @Override
    public UiPopupAbstract getPopup() {
        UiPopupAbstract popupDatabase = new UiPopupDatabase();
        return popupDatabase;
    }

    @Override
    public MouseAdapter getMouseAdapter() {
        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UiUtil.showMenuOnList(list, evt);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillTablesIntoJList(evt);
            }
        };

        return m;
    }

    public void fillTablesIntoJList(MouseEvent evt) {
        if (UiUtil.isLeftDoubleClicked(evt)) {
            JList listUiDatabases = (JList) evt.getSource();
            UiElement element = (UiElement) listUiDatabases.getSelectedValue();
            if ("table".equals(element.getData())) {
                UiPopupTable popupTable = new UiPopupTable(listUiDatabases);
                popupTable.viewTable();
                return;
            }
            String text = element.getText();
            List<String> list = database.getAllTables(text);
            UiPopupAbstract popupTable = new UiPopupTable(listUiDatabases);
            UiUtil.fillList(list, frame, popupTable, "table", listUiDatabases);

        }
    }

}
