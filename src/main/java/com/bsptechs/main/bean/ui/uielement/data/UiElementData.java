/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean.ui.uielement.data;

import com.bsptechs.main.dao.impl.DatabaseDAOImpl;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import java.util.List;
import javax.swing.JPopupMenu;

/**
 *
 * @author sarkhanrasullu
 */
public abstract class UiElementData {

    public static DatabaseDAOInter database = new DatabaseDAOImpl();

    public abstract void onClick();

    public abstract void onDoubleClick();
    
    public abstract JPopupMenu getPopup();
    
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    
    
    public abstract List<? extends UiElementData> getSubList();
    
    public abstract String getIcon();
     
}
