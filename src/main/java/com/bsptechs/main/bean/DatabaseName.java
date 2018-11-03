package com.bsptechs.main.bean;

public class DatabaseName {

    private String name;
    private NConnection connection;

    public DatabaseName() {
    }

    public DatabaseName(String name, NConnection connection) {
        this.name = name;
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NConnection getConnection() {
        return connection;
    }

    public void setConnection(NConnection connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return name;
    }

}