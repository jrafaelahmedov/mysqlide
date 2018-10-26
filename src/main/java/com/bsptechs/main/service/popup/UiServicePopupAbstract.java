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
public abstract class UiServicePopupAbstract {

    protected JFrame frame;

    protected UiServicePopupAbstract(JFrame frame) {
        this.frame = frame;
    }

    public abstract JPopupMenu popup();

    protected void addActionListener(JMenuItem item, AbstractActionListenerAdder adder) {
        item.addActionListener((java.awt.event.ActionEvent evt) -> {
            adder.action();
        });
    }

    protected JMenuItem menuItem(JPopupMenu menu, String text) {
        JMenuItem item = new JMenuItem(text);
        menu.add(item);
        return item;
    }
}
