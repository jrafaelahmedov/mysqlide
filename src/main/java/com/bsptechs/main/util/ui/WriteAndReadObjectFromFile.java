/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.util.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Penthos
 */
public class WriteAndReadObjectFromFile {

    public static void main(String[] args) {
//      List<User> list = new ArrayList<>();
//      
//
//        list.add(new User("RUSLANN", "4567", "sadsdsas", "ssaas"));
//
//       writeObjectToFile(list, FILENAME);
//        System.out.println(readObjectFromFile(FILENAME));
    }

    public static boolean writeObjectToFile(Object object, String name) throws IOException {

        boolean exists = new File(name).exists();
        FileOutputStream fos = new FileOutputStream(name, true);
        ObjectOutputStream oos = exists ? new ObjectOutputStream(fos) {
            @Override
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        } : new ObjectOutputStream(fos);

        try {//try-with-resources

            fos = new FileOutputStream(name);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            return true;

        } catch (Exception ex) {

            throw new RuntimeException(ex);

        } finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static Object readObjectFromFile(String name) throws Exception {
        Object rper = null;
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (fis.available() > 0) {
            try {
                rper = ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ois.close();
        return rper;
    }

    public static void writeObjectToFilee(Object object, String name) throws IOException {

    }
}

//
////    public static boolean writeObjectToFile(List<User> s, String name) {
////        FileOutputStream fos = null;
////        ObjectOutputStream oos = null;
////        File f = new File(name);
////
////        try {//try-with-resources
////
////            fos = new FileOutputStream(name, true);
////            oos = new ObjectOutputStream(fos);
////            oos.writeObject(s);
////            return true;
////
////        } catch (Exception ex) {
////
////            throw new RuntimeException(ex);
////
////        } finally {
////
////            if (fos != null) {
////                try {
////                    fos.close();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////
////            if (oos != null) {
////                try {
////                    oos.close();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////
////        }
////    }
//
//    public static List<User> readObjectFromFile(String name) {
//        File f = new File(name);
//        Object obj = null;
//        List<User>newList= new ArrayList<>();
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
////            List<NConnection> vectorUser = (List<NConnection>) ois.readObject();
//           List<User>list =(List<User>) ois.readObject();
//           
//
//            Iterator<User> iter = list.iterator();
//            while (iter.hasNext()) {
//                User u = iter.next();
//                newList.add(u);
//                
//
//            }
//            return newList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        return null;
//    }

