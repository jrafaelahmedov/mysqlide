package com.bsptechs.main.util.file;

import java.io.*;

public class WriteToFileIO {

    public static boolean writeObjectToFile(Object object, String name) throws RuntimeException {

        try (FileOutputStream fout = new FileOutputStream(name);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(object);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
