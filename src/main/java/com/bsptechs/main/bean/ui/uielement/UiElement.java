/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.uielement;

import com.bsptechs.main.bean.ui.uielement.data.UiElementData;
import javax.swing.JFrame;

/**
 *
 * @author sarkhanrasullu
 */
public  class UiElement {
    private String text;
    private UiElementData data;
    private JFrame frame;
    
    public UiElement(UiElementData data){
        this.data = data;
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

    public UiElementData getData() {
        return data;
    }

    public void setData(UiElementData data) {
        this.data = data;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    
    
 
    @Override
    public String toString() {
        return text;
    }
    
    
    
    
}
