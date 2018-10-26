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
import javax.swing.SwingUtilities;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServiceMainFrame {

    private DatabaseDAOInter database = null;
    private JFrame frame = null;
    UiServicePopupAbstract popupServiceTable = null;
    UiServicePopupAbstract popupServiceDatabase = null;

    public UiServiceMainFrame(JFrame frame) {
        this.frame = frame;
        this.popupServiceTable = new UiServicePopupTable(frame);
        this.popupServiceDatabase = new UiServicePopupDatabase(frame);
        this.database = new DatabaseDAOImpl();
    }

    public void fillTablesIntoJList(MouseEvent evt) {
        if (UiUtil.isDoubleClicked(evt) & SwingUtilities.isLeftMouseButton(evt)) {
            JList listUiDatabases = (JList) evt.getSource();
            UiElement element = (UiElement) listUiDatabases.getSelectedValue();
            List<String> list = database.getAllTables(element.getText());
            UiUtil.fillList(list, frame, popupServiceTable.popup(), listUiDatabases);
        }
    }

    public void fillDatabasesIntoJList(JList databaseJList) {
        List<String> databases = database.getAllDatabases();
        UiUtil.fillList(databases, frame, popupServiceDatabase.popup(), databaseJList);
    }

}
