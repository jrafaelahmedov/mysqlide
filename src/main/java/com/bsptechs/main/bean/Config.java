/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.bean;

import com.bsptechs.main.Main;
import com.bsptechs.main.util.ui.MainFrameUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Penthos
 */
public final class Config implements Serializable {

    private static final String fileName = "mySql.txt";
    private List<NConnection> connections = null;
    private static NConnection currentConnection = null;
    private static Config config = null;

    public static void initialize() {
        config = MainFrameUtility.readConfig();
    }

    public static Config instance() {
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

    public static void setConnection(NConnection connection) {
        currentConnection = connection;
    }

    public static NConnection getCurrentConnection() {
        return currentConnection;
    }

    public static String getFileName() {
        return fileName;
    }
    private static volatile Main main;

    public static void setMain(Main frame) {
        main = frame;
    }

    public static Main getMain() {
        return main;
    }

}
