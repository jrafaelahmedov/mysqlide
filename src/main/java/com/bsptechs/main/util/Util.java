/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util;

import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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

    public static void addPanelToTab(JTabbedPane tab, JPanel panel, String title) {
        int count = tab.getTabCount();
        tab.addTab(title, panel);
        tab.setSelectedIndex(tab.getTabCount() - 1);
    }

    public static void centralizeJFrame(JFrame frame) {
        frame.setSize(220, 400);
        frame.setLocationRelativeTo(null);
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

}
