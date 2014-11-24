/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Account;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vanguard
 */
public class AccountSvcSIOImplTest {

    @Test
    public void testStore() throws Exception {
        Account account = new Account();
        account.setFirstName("Frederick");
        account.setLastName("Posh");
        AccountSvcSIOImpl accountSvc = new AccountSvcSIOImpl();
        try {
            assertSame(accountSvc.store(account), account);
        } catch (Exception e) {
            fail("Could not persist");
        }
        assertNotNull(accountSvc.store(account));
    }
}
