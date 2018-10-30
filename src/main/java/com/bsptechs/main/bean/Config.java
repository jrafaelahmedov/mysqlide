/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Penthos
 */
public final class Config implements Serializable {

    private List<NConnection> connections = null;
    private NConnection selectedConnection = null;
    
    private static Config config = null;

    public static Config instance() {
        if (config == null) {
            config = new Config();
        }

        return config;
    }

    public List<NConnection> getConnections() {
        return connections;
    }

    public void setConnections(List<NConnection> connections) {
        this.connections = connections;
    }

    public void appendConnection(NConnection connection) {
        if (connections == null) {
            connections = new ArrayList<>();
        }
        connections.add(connection);
    }
    
    
    public void setConnection(NConnection connection){
        this.selectedConnection = connection;
    }

    public NConnection getSelectedConnection() {
        return selectedConnection;
    }
    
    

}
