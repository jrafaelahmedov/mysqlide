/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.inter;

import static com.bsptechs.main.FrameMysqlConnection.FILENAME;
import com.bsptechs.main.NConnection;
import com.bsptechs.main.bean.User;
import com.bsptechs.main.util.ui.WriteAndReadObjectFromFile;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author sarkhanrasullu
 */
public abstract class AbstractDatabase {

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
      User nc=  (User) WriteAndReadObjectFromFile.readObjectFromFile(FILENAME);
        
        System.out.println(nc);
        System.out.println("u="+nc.getUsers());
//        System.out.println("2nc="+nc);
//            System.out.println(list);

    }

    public Connection connect(String ipAdr, String port, String userName, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + ipAdr + ":" + port + "/";
        String username = userName;
        String password = pass;
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

//    public Connection connected() throws IOException, ClassNotFoundException, SQLException {
//        User user = (User) WriteAndReadObjectFromFile.readObjectFromFile(FILENAME);
//        return connect(user.getIpAdr(), user.getPort(), user.getUserName(), user.getPassword());
//
//    }
}
