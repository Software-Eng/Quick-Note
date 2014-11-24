/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steven
 */
public class AccountSvcJDBCImplTest {

    @Test
    public void testStore() throws Exception {
        IAccountSvc impl = new AccountSvcJDBCImpl();
        Account account = new Account();
        account.setFirstName("Frederick");
        account.setLastName("Posh");
        account = impl.store(account);
        assertNotNull(account);
        assertSame(impl.store(account), account); //Assert object being stored is same as obstantiated
        assertTrue("Frederick Posh".equals(account.getName()));
        assertFalse(account.getId() == 0);
        System.out.println("The stored account was: " + account);

    }

}
