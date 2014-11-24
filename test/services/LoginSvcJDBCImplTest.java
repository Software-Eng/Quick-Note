/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Bill;
import domain.Login;
import java.util.ArrayList;
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
public class LoginSvcJDBCImplTest {

    /**
     * Test of store method, of class LoginSvcJDBCImpl.
     */
    @Test
    public void testStoreANDCRUD() throws Exception {
        ILoginSvc impl = new LoginSvcJDBCImpl();
        Login login = new Login();
        login.setUsername("Admin");
        login.setPassword("Root");
        login = impl.store(login);
        assertNotNull(login);
        assertSame(impl.store(login), login);
        assertTrue("Admin".equals(login.getUsername()));
        assertFalse(login.getId() == 0);
        System.out.println("The stored login was: " + login);
        // test retrieve id
        login = impl.retrieve(login.getId());
        assertNotNull(login);
        // test retrieve by id number
        login = impl.retrieve(1);
        assertNotNull(login);
        // Test update
        login = impl.update(login);
        login.setUsername("Atari");
        login.setPassword("Scooby");
        assertNotNull(login);
        assertEquals("Atari", login.getUsername());
        // Test delete
        login = impl.delete(impl.retrieve(1));
        assertEquals(null, impl.retrieve(1));
    }

}
