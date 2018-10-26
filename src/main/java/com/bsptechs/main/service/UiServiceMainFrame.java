/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import com.bsptechs.main.popup.UiPopupAbstract;
import com.bsptechs.main.popup.UiPopupDatabase;
import com.bsptechs.main.popup.UiPopupTable;
import com.bsptechs.main.bean.UiElement;
import com.bsptechs.main.dao.DatabaseDAOImpl;
import com.bsptechs.main.dao.DatabaseDAOInter;
import com.bsptechs.main.util.ui.UiUtil;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServiceMainFrame {

    private DatabaseDAOInter database = null;
    private JFrame frame = null;

    public UiServiceMainFrame(JFrame frame) {
        this.frame = frame;
        this.database = new DatabaseDAOImpl();
    }

    public void fillTablesIntoJList(MouseEvent evt) {
        if (UiUtil.isDoubleClicked(evt) & SwingUtilities.isLeftMouseButton(evt)) {
            JList listUiDatabases = (JList) evt.getSource();
            UiElement element = (UiElement) listUiDatabases.getSelectedValue();
            List<String> list = database.getAllTables(element.getText());
            UiPopupAbstract popupTable = new UiPopupTable();
            UiUtil.fillList(list, frame, popupTable, listUiDatabases);
        }
    }

    public void fillDatabasesIntoJList(JList databaseJList) {
        List<String> databases = database.getAllDatabases();
        UiPopupAbstract popupDatabase = new UiPopupDatabase();

        UiUtil.fillList(databases, frame, popupDatabase, databaseJList);
    }

}
