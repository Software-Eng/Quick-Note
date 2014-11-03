/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Bill;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanguard
 */
public class BillSvcSIOImpl implements IBillSvc {

    //Global variables
    private final String FILENAME = "billList";
    private ArrayList<Bill> billListCache = new ArrayList();

    //Stores the file in the billListCache
    public BillSvcSIOImpl() {
        init();
    }

    //Persists billListCache
    public Bill store(Bill bill) throws ServiceException {
        try {
            //Appends an account, and persists billListCache
            billListCache.add(bill);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            oos.writeObject(billListCache);
            oos.flush();
            oos.close();
            //Throws an exception
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return bill;
    }

    //Stores an array in billListCache
    private void init() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
            billListCache.addAll((ArrayList<Bill>) ois.readObject());
            ois.close();
            //Prints an error msg to the console
        } catch (Exception e) {
            System.out.println("init");
        }
    }

    @Override
    public Bill create(Bill bill) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill update(Bill bill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill delete(Bill bill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Bill> retrieve(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
