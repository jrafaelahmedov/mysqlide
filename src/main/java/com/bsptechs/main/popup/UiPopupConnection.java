/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.UiElement;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupConnection extends UiPopupAbstract {

    private JFrame frame;
    private JList list;

    public UiPopupConnection(JFrame frame, JList list) {
        this.frame = frame;
        this.list = list;

        addMenuItem("Delete Connection", () -> {
            delete();
        });
        addMenuItem("Connection Properties", () -> {
            properties();
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

    public void connection() {
        UiElement ui = (UiElement) list.getModel().getElementAt(list.getSelectedIndex());
        System.out.println("connection connection");
        //Tebriz burani dolduracaq
    }

}
