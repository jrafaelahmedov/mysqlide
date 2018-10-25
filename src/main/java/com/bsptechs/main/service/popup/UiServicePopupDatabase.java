/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServicePopupDatabase extends UiServicePopupAbstract {

    public UiServicePopupDatabase(JFrame frame, JPopupMenu popupMenu) {
        super(frame, popupMenu);
    }

    @Override
    public void delete() {
        System.out.println("delete database");
        //Tebriz burani dolduracaq
    }

    @Override
    public void properties() {
        System.out.println("properites database");
        //Tebriz burani dolduracaq
    }

    public void newQuery() {
        System.out.println("new query");
        //Rafael burani dolduracaq
    }

}
