/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.impl;

import com.bsptechs.main.bean.Config;
import com.bsptechs.main.bean.NConnection;
import com.bsptechs.main.bean.TableName;
import com.bsptechs.main.bean.table.TableCell;
import com.bsptechs.main.bean.table.TableData;
import com.bsptechs.main.bean.table.TableRow;
import com.bsptechs.main.dao.inter.AbstractDatabase;
import com.bsptechs.main.dao.inter.DatabaseDAOInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Penthos
 */
public class DatabaseDAOImpl extends AbstractDatabase implements DatabaseDAOInter {

    @Override
    public List<String> getAllDatabases(NConnection connection) {
        List<String> databasesList = new ArrayList<>();

        try {
            Connection conn = connect(connection);
            Statement stmt = conn.createStatement();
            ResultSet resultset = stmt.executeQuery("SHOW DATABASES;");

            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.getResultSet();
            }

            while (resultset.next()) {
                String result = resultset.getString("Database");
                databasesList.add(result);
            }
            NConnection selectedConnection = Config.getCurrentConnection();
            selectedConnection.setDatabases(databasesList);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return databasesList;
        }
    }

    @Override
    public List<TableName> getAllTables(String databaseName) {
        List<TableName> list = new ArrayList<>();
        try {
            Connection conn = connect(Config.getCurrentConnection());
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
    public boolean renameTable(String DBname, String oldTblName, String newTblName) {
        try {
            Connection conn = connect(Config.getCurrentConnection());
            PreparedStatement stmt = conn.prepareStatement("RENAME TABLE `" + DBname + "`.`" + oldTblName + "` TO `" + DBname + "`.`" + newTblName + "`");//PrepapredStatement ile edende dirnaqlara gore ishlemirdi ona gore bele etdim
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<String> getColumns(ResultSet rs) throws SQLException {
        ResultSetMetaData metdata = rs.getMetaData();
        int cnt = metdata.getColumnCount();
        List<String> columns = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            String columnName = metdata.getColumnName(i + 1);
            columns.add(columnName);
        }
        return columns;
    }

    @Override
    public TableData runQuery(String query) throws ClassNotFoundException, SQLException {
        if (Config.getCurrentDatabaseName() == null || Config.getCurrentDatabaseName().isEmpty()) {
            JOptionPane.showMessageDialog(Config.getMain(), "Choose a database");
            return null;
        }
        TableData table = null;
        Connection conn = connect(Config.getCurrentConnection());
        Statement stmt = conn.createStatement();
        String setDatabase = "USE " + Config.getCurrentDatabaseName() + ";";

        stmt.executeQuery(setDatabase);
        ResultSet rs = stmt.executeQuery(query);

        List<String> columns = getColumns(rs);
        List<TableRow> rows = new ArrayList<>();
        while (rs.next()) {
            List<TableCell> rowCells = new ArrayList<>();

            for (String column : columns) {
                Object o = rs.getObject(column);
                rowCells.add(new TableCell(column, o));
            }

            rows.add(new TableRow(rowCells));
        }
        table = new TableData(rows, columns);
        return table;
    }

    public static void main(String[] args) throws Exception {
        NConnection conn = new NConnection("localhost", "localhost", "3306", "root", "");
        Config.setConnection(conn);

        TableData data = new DatabaseDAOImpl().runQuery("SELECT * FROM filemanagementsystem.user;");

        List<TableRow> rows = data.getRows();
        for (TableRow r : rows) {
            System.out.println(r);
            System.out.println("-------------------");
            List<TableCell> cells = r.getCells();

            for (TableCell c : cells) {
                System.out.println(c);
            }
            System.out.println("");
        }
    }

}
