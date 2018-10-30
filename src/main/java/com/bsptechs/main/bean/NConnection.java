/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

import java.io.Serializable;

/**
 *
 * @author Penthos
 */
public class NConnection implements Serializable {

    private String ipAdr;
    private String port;
    private String userName;
    private String password;

    public NConnection() {
    }

    public NConnection(String ipAdr, String port, String userName, String password) {
        this.ipAdr = ipAdr;
        this.port = port;
        this.userName = userName;
        this.password = password;
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

}
