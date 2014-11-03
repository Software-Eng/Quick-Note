/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.*;
import java.util.*;

/**
 *
 * @author Steven
 */
public interface IBillSvc extends IService {

    public final String NAME = "IBillSvc";

    public Bill create(Bill bill) throws ServiceException;

    public Bill retrieve(int id);

    public ArrayList<Bill> retrieve(String name);

    public Bill update(Bill bill);

    public Bill delete(Bill bill);

}
