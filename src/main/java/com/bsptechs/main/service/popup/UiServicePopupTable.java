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
public class UiServicePopupTable extends UiServicePopupAbstract{

    public UiServicePopupTable(JFrame frame, JPopupMenu popupMenu) {
        super(frame, popupMenu);
    }

    @Override
    public void delete() {
        System.out.println("table delete");
        //Tebriz burani dolduracaq
    }

    @Override
    public void properties() {
        System.out.println("table properties");
        //Tebriz burani dolduracaq
    }
    
}
