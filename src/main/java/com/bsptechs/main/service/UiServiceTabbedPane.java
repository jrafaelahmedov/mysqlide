/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServiceTabbedPane extends UiService {

    private JTabbedPane pane;

    public UiServiceTabbedPane(String serviceName, JTabbedPane pane) {
        super(serviceName);
        this.pane = pane;
    }

    public void addPanelToTab(JPanel panel, String title) {
        int count = pane.getTabCount();
        pane.addTab(title, panel);
        pane.setSelectedIndex(pane.getTabCount() - 1);
    }
     
}
