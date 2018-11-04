package com.bsptechs.main.bean;

import com.bsptechs.main.bean.ui.uielement.data.UiElementDataDatabase;
import com.bsptechs.main.bean.ui.uielement.data.UiElementDataConnection;
import com.bsptechs.main.Main;
import com.bsptechs.main.util.FileUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Penthos
 */
public final class Config implements Serializable {

    private static final String fileName = "mySql.txt";
    private List<UiElementDataConnection> connections = null;
    private static UiElementDataConnection currentConnection = null;
    private static UiElementDataDatabase currentDatabaseName = null;
    private static Config config = null;

    public static void initialize() {
        config = readConfig();
    }

    public static Config instance() {
        return config;
    }

    public List<UiElementDataConnection> getConnections() {
        return connections;
    }

    public UiElementDataConnection getConnectionByName(String connectionName) {
        if (connections == null) {
            return null;
        }
        for (int i = 0; i < connections.size(); i++) {
            UiElementDataConnection connection = connections.get(i);
            if (connection.getName().equalsIgnoreCase(connectionName)) {
                return connection;
            }
        }
        return null;
    }

    public void appendConnection(UiElementDataConnection connection) {
        if (connections == null) {
            connections = new ArrayList<>();
        }
        connections.add(connection);
    }

    

    public static void setCurrentConnection(UiElementDataConnection connection) {
        currentConnection = connection;
    }
//

    public static UiElementDataConnection getCurrentConnection() {
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

    public static UiElementDataDatabase getCurrentDatabaseName() {
        return currentDatabaseName;
    }

    public static void setCurrentDatabaseName(UiElementDataDatabase currentDatabaseName) {
        Config.currentDatabaseName = currentDatabaseName;
    }

    public static void saveConfig() {
        FileUtility.writeObjectToFile(Config.instance(), Config.getFileName());
    }

    public static Config readConfig() {
        Object configObj = FileUtility.readFileDeserialize(Config.getFileName());
        if (configObj == null) {
            return new Config();
        } else {
            return (Config) configObj;
        }
    }

}
