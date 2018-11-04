/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author sarkhanrasullu
 */
public  class UiElement {
    private String text;
    private Object data;
    private JPopupMenu popup;
    private JFrame frame;
    private JPanel panel;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    

    public UiElement() {
    }

    public UiElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPopupMenu getPopup() {
        return popup;
    }

    public void setPopup(JPopupMenu popup) {
        this.popup = popup;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
    
    
}
