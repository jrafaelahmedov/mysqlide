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
public class UiPopupConnection extends UiPopupAbstract {


    @Override
    public JPopupMenu popup() {
        
        JMenuItem itemDelete = menuItem("Delete Connection");
        JMenuItem itemProperties = menuItem("Connection Properties");

        addActionListener(itemProperties, () -> {properties();});
        addActionListener(itemDelete, () -> {delete();});

        return this;
    }
    
    
    public void delete() {
        System.out.println("delete database");
        //Tebriz burani dolduracaq
    }

    public void properties() {
        System.out.println("properites database");
        //Tebriz burani dolduracaq
    }

}
