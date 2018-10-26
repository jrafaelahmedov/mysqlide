/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServicePanelTable extends UiService {

    private JPanel panel;

    public UiServicePanelTable(String serviceName,JPanel panel) {
        super(serviceName);
        this.panel = panel;
    }

    public void fillTable(JTable table) {
        System.out.println("new query");
        //Tebriz burani dolduracaq
    }

}
