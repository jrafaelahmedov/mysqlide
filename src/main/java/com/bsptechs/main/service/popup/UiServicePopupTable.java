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
public class UiServicePopupTable extends UiServicePopupAbstract {

    public UiServicePopupTable(JFrame frame) {
        super(frame);
    }

    @Override
    public JPopupMenu popup() {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem itemDelete = menuItem(popup,"Delete Table");
        JMenuItem itemProperties = menuItem(popup, "Table Properties");

        addActionListener(itemProperties, () -> {properties();});
        addActionListener(itemDelete, () -> {delete();});
        return popup;
    }

    private void delete() {
        System.out.println("table delete");
        //Tebriz burani dolduracaq
    }

    private void properties() {
        System.out.println("table properties");
        //Tebriz burani dolduracaq
    }

}
