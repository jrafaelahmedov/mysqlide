/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import com.bsptechs.main.bean.UiElement;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author sarkhanrasullu
 */
public class UiUtil {

   
    public static void fillList(List<String> textList, JFrame frame, JPopupMenu popup, JList uiList) {
        DefaultListModel dm = new DefaultListModel();
        for (String text : textList) {
            UiElement uiElement = new UiElement(text);
            uiElement.setFrame(frame);
            uiElement.setPopup(popup);
            dm.addElement(uiElement);
        }

        uiList.setModel(dm);
    }

    public static void showMenuOnList(JList list, MouseEvent evt) {
        if (list.getSelectedIndex() > -1 && SwingUtilities.isRightMouseButton(evt)) {
            UiElement element = (UiElement) list.getModel().getElementAt(list.getSelectedIndex());
            int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
            element.getPopup().show(element.getFrame(), mouseX, mouseY - 25);
        }
    }

    public static boolean isDoubleClicked(MouseEvent evt) {
        return evt.getClickCount() == 2;
    }
}
