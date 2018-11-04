/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.util.ui.FrameMySQLConnectionUtil;
import com.bsptechs.main.util.ui.MainFrameUtility;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupConnection extends UiPopupAbstract {

    public UiPopupConnection() {
        addMenuItem("Delete Connection", () -> {
            delete();
        });
        addMenuItem("Connection Properties", () -> {
            properties();
        });

        addMenuItem("Connect", () -> {
            connect();
        });

        addMenuItem("Disconnect", () -> {
            disconnect();
        });
    }

    public void delete() {
        System.out.println("delete connection");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("properites connection");
        FrameMySQLConnectionUtil.showMySQLConnectionAsUpdate();
    }

    public void connect() {
        System.out.println("connection connection");
        NConnection cn = MainFrameUtility.getSelectedConnectionFromList();
        MainFrameUtility.connect(cn);
        //Tebriz burani dolduracaq
    }

    public void disconnect() {
        System.out.println("disconnection connection");

        MainFrameUtility.disconnect();
        //Tebriz burani dolduracaq
    }

}
