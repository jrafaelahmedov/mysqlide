/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import com.bsptechs.main.popup.UiPopupAbstract;
import com.bsptechs.main.util.ui.UiUtil;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author sarkhanrasullu
 */
public abstract class UiServiceJList extends UiService {

    protected JList list = null;
    protected JFrame frame = null;

    public UiServiceJList(String serviceName, JFrame frame, JList list) {
        super(serviceName);
        this.list = list;
        this.frame = frame;
        fillList();
        addMouseAdapter();
    }

    public final void fillList() {
        List<String> items = getItems();
        UiPopupAbstract popup = getPopup();

        UiUtil.fillList(items, frame, popup, null, list);
    }

    public abstract List<String> getItems();

    public abstract UiPopupAbstract getPopup();

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
                //bura connect ol
            }
        };
        return m;
    }

    public void addMouseAdapter() {
        list.addMouseListener(getMouseAdapter());
    }
}
