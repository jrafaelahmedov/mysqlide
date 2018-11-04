/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import com.bsptechs.main.FrameMysqlConnection;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

/**
 *
 * @author sarkhanrasullu
 */
public class FrameMySQLConnectionUtil {
    
    public static void showMySQLConnectionAsUpdate() {
        FrameMysqlConnection f = new FrameMysqlConnection();
        f.showAsUpdate();
    }

    public static void showFrameForMySQLConnection(JFrame frame, JTabbedPane tab, JTree listDatabases) {
        new FrameMysqlConnection().setVisible(true);
    }

}
