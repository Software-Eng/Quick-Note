/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.*;
import domain.*;
import java.io.*;

/**
 *
 * @author Steven
 */
public class AccountSvcSIOImpl implements IAccountSvc {

    //Global variables
    private final String FILENAME = "accountList";
    private ArrayList<Account> accountListCache = new ArrayList();

    //Stores the file in the accountListCache
    public AccountSvcSIOImpl() {
        init();
    }

    //Persists accountListCache
    @Override
    public Account store(Account account) throws ServiceException {
        try {
            //Appends an account, and persists accountListCache
            accountListCache.add(account);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            oos.writeObject(accountListCache);
            oos.flush();
            oos.close();
            //Throws an exception
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return account;
    }

    //Stores an array in accountListCache
    private void init() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
            accountListCache.addAll((ArrayList<Account>) ois.readObject());
            ois.close();
            //Prints an error msg to the console
        } catch (Exception e) {
            System.out.println("init");
        }
    }

    @Override
    public Account retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account delete(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Account> retrieve(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account update(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
