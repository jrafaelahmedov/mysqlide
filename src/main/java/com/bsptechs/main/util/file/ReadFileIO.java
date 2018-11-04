package com.bsptechs.main.util.file;

import java.io.*;

public class ReadFileIO {

    public static Object readFileDeserialize(String name){
        Object obj=null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))){
            obj = in.readObject();
        }finally{
            return obj;
        }
    }
}
