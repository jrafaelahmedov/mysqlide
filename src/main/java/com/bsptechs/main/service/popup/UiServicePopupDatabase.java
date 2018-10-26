/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service.popup;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author sarkhanrasullu
 */
public class UiServicePopupDatabase extends UiServicePopupAbstract {

    public UiServicePopupDatabase(JFrame frame) {
        super(frame);
    }

    public void delete() {
        System.out.println("delete database");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("properites database");
        //Tebriz burani dolduracaq
    }

    public void newQuery() {
        System.out.println("new query");
        //Rafael burani dolduracaq
    }

    @Override
    public JPopupMenu popup() {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem itemDelete = menuItem(popup,"Delete Database");
        JMenuItem itemProperties = menuItem(popup, "Database Properties");
        JMenuItem itemNewQuery = menuItem(popup, "New Query");

        addActionListener(itemProperties, () -> {properties();});
        addActionListener(itemDelete, () -> {delete();});
        addActionListener(itemNewQuery, () -> {newQuery();});

        return popup;
    }

}
