/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Account;
import domain.Bill;
import domain.Login;
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
public class LoginSvcSIOImplTest {

    @Test
    public void testStore() throws Exception {
        Login login = new Login();
        login.setUsername("GRick");
        login.setPassword("Grimes");
        LoginSvcSIOImpl loginSvc = new LoginSvcSIOImpl();
        try {
            assertSame(loginSvc.store(login), login);
        } catch (Exception e) {
            fail("Could not persist");
        }
        assertNotNull(loginSvc.store(login));
    }
}
