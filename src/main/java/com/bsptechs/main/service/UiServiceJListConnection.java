/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import com.bsptechs.main.dao.impl.ConnectionDAOImpl;
import com.bsptechs.main.dao.inter.ConnectionDAOInter;
import com.bsptechs.main.popup.UiPopupAbstract;
import com.bsptechs.main.popup.UiPopupConnection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServiceJListConnection extends UiServiceJList {

    private ConnectionDAOInter dao = new ConnectionDAOImpl();

    public UiServiceJListConnection(String serviceName, JFrame frame, JList list) {
        super(serviceName, frame, list);
    }

    @Override
    public List<String> getItems() {
        dao = new ConnectionDAOImpl();
        List<String> list = dao.getAllConnection();
        return list;
    }

    @Override
    public UiPopupAbstract getPopup() {
        UiPopupAbstract popup = new UiPopupConnection();
        return popup;
    }

}
