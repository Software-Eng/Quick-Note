/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Bill;
import domain.Login;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Vanguard
 */
public class LoginSvcSIOImpl implements ILoginSvc {

    //Global variables
    private final String FILENAME = "loginList";
    private ArrayList<Login> loginListCache = new ArrayList();

    //Stores the file in the loginListCache
    public LoginSvcSIOImpl() {
        init();
    }

    //Persists LoginListCache
    public Login store(Login login) throws ServiceException {
        try {
            //Appends an account, and persists loginListCache
            loginListCache.add(login);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            oos.writeObject(loginListCache);
            oos.flush();
            oos.close();
            //Throws an exception
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return login;
    }

    //Stores an array in loginlistCache
    private void init() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
            loginListCache.addAll((ArrayList<Login>) ois.readObject());
            ois.close();
            //Prints an error msg to the console
        } catch (Exception e) {
            System.out.println("init");
        }
    }

    @Override
    public Login retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Login> retrieve(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login delete(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login update(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
