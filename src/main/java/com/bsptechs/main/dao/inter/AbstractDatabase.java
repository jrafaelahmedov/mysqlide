/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.inter;

import com.bsptechs.main.bean.NConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sarkhanrasullu
 */
public abstract class AbstractDatabase {

    public Connection connect(NConnection connection) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + connection.getIpAdr() + ":" + connection.getPort() + "/";
        String username = connection.getUserName();
        String password = connection.getPassword();
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

}
