/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.main.service;

import java.util.HashMap;

/**
 *
 * @author sarkhanrasullu
 */
public abstract class UiService {

    private static HashMap<String, UiService> services = new HashMap<>();

    public UiService(String serviceName) {
        services.put(serviceName, this);
    }

    public static UiService getUiService(String serviceName) {
        return services.get(serviceName);
    }
}
