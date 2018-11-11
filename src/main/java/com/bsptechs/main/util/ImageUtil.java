/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author sarkhanrasullu
 */
public class ImageUtil {
    public static ImageIcon getIcon(String iconName){//get Icon methodunu men duzeltmishem bu ozu /icons elave edir
        ImageIcon imageIcon = new ImageIcon(ImageUtil.class.getResource("/icons/"+iconName));//bax burada
        Image temp = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        return new ImageIcon(temp);
    }
}
