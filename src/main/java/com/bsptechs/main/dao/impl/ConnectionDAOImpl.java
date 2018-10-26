/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.dao.impl;

import com.bsptechs.main.dao.inter.AbstractDatabase;
import com.bsptechs.main.dao.inter.ConnectionDAOInter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Penthos
 */
public class ConnectionDAOImpl extends AbstractDatabase implements ConnectionDAOInter {

    @Override
    public List<String> getAllConnection() {
        List<String> list = Arrays.asList("localhost", "rafael mysql");
        return list;
    }

}
