/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Penthos
 */
public class NConnection implements Serializable {

    private String name;
    private String ipAdr;
    private String port;
    private String userName;
    private String password;
    private transient Connection parentConnection;
    private transient List<String> databases;

    public NConnection() {
    }

    public NConnection(String name, String ipAdr, String port, String userName, String password) {
        this.name = name;
        this.ipAdr = ipAdr;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public List<String> getDatabases() {
        return databases;
    }

    public void setDatabases(List<String> databases) {
        this.databases = databases;
    }

    public String getIpAdr() {
        return ipAdr;
    }

    public void setIpAdr(String ipAdr) {
        this.ipAdr = ipAdr;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection getParentConnection() {
        return parentConnection;
    }

    public void setParentConnection(Connection parentConnection) {
        this.parentConnection = parentConnection;
    }
 
    @Override
    public String toString() {
        return name;
    }

}
