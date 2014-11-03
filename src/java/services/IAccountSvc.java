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
public interface IAccountSvc extends IService {

    public final String NAME = "IAccountSvc";

    public Account store(Account account) throws ServiceException;

    public Account retrieve(int id);

    public ArrayList<Account> retrieve(String lastName);

    public Account delete(Account account);
}
