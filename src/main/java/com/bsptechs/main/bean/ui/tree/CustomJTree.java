/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.tree;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.ui.panel.PanelUiElementInformation;
import com.bsptechs.main.bean.ui.uielement.UiElement;
import com.bsptechs.main.bean.ui.uielement.UiElementConnection;
import com.bsptechs.main.bean.ui.uielement.UiElementDatabase;
import com.bsptechs.main.bean.ui.uielement.UiElementTable;
import com.bsptechs.main.util.MouseUtil;
import java.awt.event.MouseAdapter;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author sarkhanrasullu
 */
public class CustomJTree extends AbstractJTree {

    @Override
    protected MouseAdapter getAdapter() {

        MouseAdapter m = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                UiElement element = getSelectedUiElement();
                if (element == null) {
                    return;
                }
                if (MouseUtil.isRightClicked(e)) {
                    element.getPopup().show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefaultMutableTreeNode selectedUiElement = getSelectedNode();
                if (selectedUiElement == null || !(selectedUiElement instanceof UiElement)) {
                    return;
                }
                UiElement element = (UiElement) selectedUiElement;

                if (MouseUtil.isLeftDoubleClicked(evt)) {
                    element.onDoubleClick();
                }

                if (MouseUtil.isLeftClicked(evt)) {
                    System.out.println("left clicked");
                    PanelUiElementInformation pnlInfor = Config.getMain().getInformationPanel();
                    pnlInfor.preparePanel(element);
                }
            }
        };

        return m;
    }

    public UiElementDatabase getSelectedDatabase() {
        return getSelectedUiElementGeneric(UiElementDatabase.class);
    }

    public UiElementTable getSelectedTable() {
        return getSelectedUiElementGeneric(UiElementTable.class);
    }

    public UiElementConnection getSelectedConnection() {
        return getSelectedUiElementGeneric(UiElementConnection.class);
    }
}
