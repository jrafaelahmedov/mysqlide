/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.impl;

import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.dao.inter.AbstractDatabase;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Penthos
 */
public class DatabaseDAOImpl extends AbstractDatabase implements DatabaseDAOInter {

    @Override
    public List<String> getAllDatabases() {
        List<String> list = new ArrayList<>();

        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet resultset = stmt.executeQuery("SHOW DATABASES;");

            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.getResultSet();
            }

            while (resultset.next()) {
                String result = resultset.getString("Database");
                list.add(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }

    @Override
    public List<TableName> getAllTables(String databaseName) {
        List<TableName> list = new ArrayList<>();
        try (Connection conn = connect();) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM information_schema.tables where table_schema = ?");
            stmt.setString(1, databaseName);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                String result = resultset.getString("table_name");
                list.add(new TableName(result, databaseName));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            return list;
        }
    }

    @Override
    public List<String> getAllConnection() {
        List<String> list = Arrays.asList("localhost", "rafael mysql");
        return list;
    }

    @Override
    public boolean renameTable(String DBname, String oldTblName, String newTblName) {
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("RENAME TABLE `" + DBname + "`.`" + oldTblName + "` TO `" + DBname + "`.`" + newTblName + "`");
            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean emptyTable(String DBName, String tblName) {
        try (Connection conn = connect()) {

            PreparedStatement stmt = conn.prepareStatement("delete  from " + DBName + "." + tblName);

            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean truncateTable(String DBName, String tblName) {
        try (Connection conn = connect()) {

            PreparedStatement stmt = conn.prepareStatement("TRUNCATE TABLE " + DBName + "." + tblName);

            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean dublicateTable() {

        return true;
    }

    @Override
    public boolean pasteTable(String information, String DBName, String TblName) {

        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("CREATE TABLE " + DBName + "." + TblName + " LIKE " + information);
            PreparedStatement stmt1 = conn.prepareStatement("INSERT " + DBName + "." + TblName + "SELECT * FROM " + information);
            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
