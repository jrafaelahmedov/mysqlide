/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

import com.bsptechs.main.NConnection;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Penthos
 */
public class User  implements Serializable {
    

    
    
    private String ipAdr;
    private String port;
    private String userName;
    private String password;
    private List<User>users;
  

    public User() {
    }

    public User(String ipAdr, String port, String userName, String password) {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    

    @Override
    public String toString() {
        return "User{" + "ipAdr=" + ipAdr + ", port=" + port + ", userName=" + userName + ", password=" + password + '}';
    }
    

    
}
