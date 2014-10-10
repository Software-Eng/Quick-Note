/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

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
public class LoginTest {
    
    @Test
    public void testEquals() {
        Login login = new Login();
        login.setId(1);
        login.setUsername("GRick");
        login.setPassword("asd123");
        Login login2 = new Login();
        login2.setId(1);
        login2.setUsername("GRick");
        login2.setPassword("asd123");
        assertTrue(login.equals(login2));
        login2.setId(2);
        login2.setUsername("Barry");
        login2.setPassword("ff");
        assertFalse(login.equals(login2));
        System.out.println("testEquals passed!");
    }
    @Test
    public void testValidate() {
        Login login = new Login();
        login.setId(1);
        login.setUsername("GRick");
        login.setPassword("asd123");
        assertTrue("expected true", login.validate());
        login.setId(0);
        login.setUsername(null);
        login.setPassword(null);
        assertFalse("expected false", login.validate());
        System.out.println("testValidate() passed!");
    }
    
}
