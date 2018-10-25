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
public abstract class UiServicePopupAbstract {

    public JFrame frame;
    public JPopupMenu popupMenu;

    public UiServicePopupAbstract(JFrame frame, JPopupMenu popupMenu) {
        this.frame = frame;
        this.popupMenu = popupMenu;
    }

    
    
    public abstract void delete();

    public abstract void properties();
}
