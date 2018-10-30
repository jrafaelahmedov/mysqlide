/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.util.ui.MainFrameUtility;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTabbedPane;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupConnection extends UiPopupAbstract {

    private JFrame frame;
    private JList listConnections;
    private JList listDatabases;
    private JTabbedPane tab;

    public UiPopupConnection(JFrame frame, JTabbedPane tab, JList listConnections,JList listDatabases) {
        this.frame = frame;
        this.listConnections = listConnections;
        this.listDatabases = listDatabases;
        this.tab = tab;

        addMenuItem("Delete Connection", () -> {
            delete();
        });
        addMenuItem("Connection Properties", () -> {
            properties();
        });

        addMenuItem("Connect", () -> {
            connect();
        });
    }

    public void delete() {
        System.out.println("delete connection");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("properites connection");
        //Tebriz burani dolduracaq
    }

    public void connect() { 
        System.out.println("connection connection");
       
        MainFrameUtility.connect(frame, tab, listDatabases, listConnections);
        //Tebriz burani dolduracaq
    }

}
