/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.inter;

import static com.bsptechs.main.FrameMysqlConnection.FILENAME;
import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.util.ui.WriteAndReadObjectFromFile;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sarkhanrasullu
 */
public abstract class AbstractDatabase {

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
        Config nc=  (Config) WriteAndReadObjectFromFile.readObjectFromFile(FILENAME);
        
        System.out.println(nc);
        System.out.println("u="+nc.getConnections());
//        System.out.println("2nc="+nc);
//            System.out.println(list);

    }

    public Connection connect(NConnection connection) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + connection.getIpAdr() + ":" + connection.getPort() + "/";
        String username = connection.getUserName();
        String password = connection.getPassword();
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

//    public Connection connected() throws IOException, ClassNotFoundException, SQLException {
//        User user = (User) WriteAndReadObjectFromFile.readObjectFromFile(FILENAME);
//        return connect(user.getIpAdr(), user.getPort(), user.getUserName(), user.getPassword());
//
//    }
}
