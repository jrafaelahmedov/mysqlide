/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main;

import static com.bsptechs.main.FrameMysqlConnection.FILENAME;
import com.bsptechs.main.bean.User;
import com.bsptechs.main.util.ui.WriteAndReadObjectFromFile;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Penthos
 */
public class NConnection implements Serializable {
//    public static void main(String[] args) {
//        nc.setUser(new User("q", "q", "q", "q"));
//        System.out.println("z="+nc.getUser());
//    }
//   

    private User user;

    private List<User> connections;
   

    public NConnection() {
    }

    public NConnection(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getConnections() {
        return connections;
    }

    public void setConnections(List<User> connections) {
        this.connections = connections;
    }


    public static void refreshConfig(User u) throws IOException {
        WriteAndReadObjectFromFile.writeObjectToFile(u, FILENAME);

    }
    
//     public static void readConfig() throws Exception{
//         WriteAndReadObjectFromFile.readObjectFromFile(FILENAME);
//     }

    @Override
    public String toString() {
        return "NConnection{" + "user=" + user + ", connections=" + connections + '}';
    }

}
