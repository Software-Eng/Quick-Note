/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.*;
import java.util.*;

/**
 *
 * @author Steven
 */
public class Factory {
    //Old method
//    public IAccountSvc getAccountSvc() {
//        return new AccountSvcJDBCImpl();
//    }

    public IService getService(String name) throws ServiceException {
        try {
            Class c = Class.forName(getImplName(name));
            return (IService) c.newInstance();
        } catch (Exception e) {
            throw new ServiceException("Factory: " + e.getMessage());
        }
    }

    private String getImplName(String name) throws IOException {
        java.util.Properties props = new java.util.Properties();
        java.io.FileInputStream fis = new java.io.FileInputStream("Factory.properties");
        props.load(fis);
        fis.close();
        return props.getProperty(name);
    }

}
