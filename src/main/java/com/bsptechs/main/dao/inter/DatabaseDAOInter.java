/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.inter;

import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface DatabaseDAOInter {

    List<String> getAllDatabases();

    List<String> getAllTables(String databaseName);

    List<String> getAllConnection();
}
