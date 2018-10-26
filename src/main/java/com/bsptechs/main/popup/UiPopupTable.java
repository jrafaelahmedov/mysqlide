/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author sarkhanrasullu
 */
public class UiPopupTable extends UiPopupAbstract {


    @Override
    public JPopupMenu popup() {
        JMenuItem itemDelete = menuItem("Delete Table");
        JMenuItem itemProperties = menuItem( "Table Properties");

        addActionListener(itemProperties, () -> {properties();});
        addActionListener(itemDelete, () -> {delete();});
        return this;
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
