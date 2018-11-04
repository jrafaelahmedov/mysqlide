/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util;

import com.bsptechs.main.bean.ui.tree.CustomJTree;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author sarkhanrasullu
 */
public class ImageUtil {
    public static ImageIcon getIcon(String path){
        ImageIcon imageIcon = new ImageIcon(CustomJTree.class.getResource(path));
        Image temp = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        return new ImageIcon(temp);
    }
}
