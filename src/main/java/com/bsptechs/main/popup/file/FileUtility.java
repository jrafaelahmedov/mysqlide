/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.popup.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Goshgar
 */
public class FileUtility {

    private static final String FILENAME = "C:\\WorkSpace\\mysqlIde\\mysqlide\\src\\main\\java\\com\\bsptechs\\main\\popup\\file\\DBAndTblName";

    public static void writeDBAndTblNameFile(String DBName, String TblName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(DBName + "." + TblName);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static String readDBAndTblName() {
        try (InputStream in = new FileInputStream(FILENAME);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                return line;
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return null;
    }

    public static void main(String[] args) {
        readDBAndTblName();
    }
}
