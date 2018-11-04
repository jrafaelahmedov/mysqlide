/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.popup;

import com.bsptechs.main.ConnectionFrame;
import com.bsptechs.main.bean.ui.uielement.data.UiElementDataConnection;

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
    
    public UiElementDataConnection getSelectedConnection(){
        return (UiElementDataConnection) getSelectedElement().getData();
    }

    public void delete() {
        System.out.println("delete connection");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("properites connection");
        ConnectionFrame.showAsUpdate(getSelectedConnection());
    }

    public void connect() {
        System.out.println("connection connection");
        getSelectedConnection().connect();
    }

    public void disconnect() {
        System.out.println("disconnection connection");
        UiElementDataConnection cn = getSelectedConnection();
        cn.reset();
    }

}
