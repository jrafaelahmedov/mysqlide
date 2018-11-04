/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import com.bsptechs.main.bean.UiElement;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author sarkhanrasullu
 */
public class Util {
    
    public static boolean checkIp(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }
        boolean res = Pattern.matches("^localhost$|^127(?:\\.[0-9]+){0,2}\\.[0-9]+$|^(?:0*\\:)*?:?0*1$", ip);
        return res;
    }

    public static boolean checkPort(String port) {
        if (StringUtils.isEmpty(port)) {
            return true;
        }
        boolean res = Pattern.matches("(6553[0-5]|655[0-2]\\d|65[0-4]\\d{2}|6[0-4]\\d{3}|5\\d{4}|[0-9]\\d{0,3})", port);
        return res;
    }
    
     public static void showMenuOnList(JTree list, MouseEvent evt) {
        UiElement element = getUiElementFromList(list);
        System.out.println("element="+element);
        if (MainFrameUtility.isRightClicked(evt)) {
            int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
            element.getPopup().show(element.getFrame(), mouseX, mouseY - 5);
        }
    }

     
     public static UiElement getUiElementFromList(JTree list) {
        DefaultMutableTreeNode obj = getSelectedNode(list);
        if (obj != null && obj.getUserObject() instanceof UiElement) {
            return (UiElement) obj.getUserObject();
        }
        return null;
    }

    public static DefaultMutableTreeNode getSelectedNode(JTree list) {
        TreePath selectionPath = list.getSelectionPath();
        System.out.println("selectionpath="+selectionPath);
        if (selectionPath != null) {
            DefaultMutableTreeNode obj = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
            return obj;
        }
        return null;
    }

}
