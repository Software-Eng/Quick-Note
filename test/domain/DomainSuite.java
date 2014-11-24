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

public class DomainSuite {

    @Test
    public void testDomain() {

        //Create user's login
        Login accountLogin = new Login();
        Object obj = new Object();
        accountLogin.setUsername("GRick");
        accountLogin.setPassword("asd123");
        accountLogin.setId(1);

        //Testing a true Validate
        assertTrue(accountLogin.validate());

        //Testing a false Validate
        accountLogin.setId(0);
        accountLogin.setUsername(null);
        accountLogin.setPassword(null);
        assertFalse(accountLogin.validate());

        //Test equals
        assertTrue(accountLogin.equals(accountLogin));
        assertFalse(accountLogin.equals(obj));

        //Create user's address
        Address address = new Address();
        address.setAddress("5048 Lincoln St.");
        address.setApartmentNumber(502);
        address.setCity("Denver");
        address.setZip("8041");
        address.setId(1);

        //Testing a true Validate
        assertTrue(address.validate());

        //Testing a false Validate
        address.setAddress(null);
        address.setApartmentNumber(0);
        address.setCity(null);
        address.setZip(null);
        address.setId(0);

        //Test equals
        assertTrue(address.equals(address));
        assertFalse(address.equals(obj));

        //Create user's account
        Account account = new Account();
        Bill bill = new Bill();
        account.setFirstName("Rick");
        account.setLastName("Grimes");
        account.setAddress(address);
        account.setEmail("rgrimes@wd.com");
        account.setLogin(accountLogin);
        account.setId(1);
        account.setBill(bill);

        //Testing a true Validate
        assertTrue(account.validate());

        //Testing a false Validate
        account.setFirstName("");
        account.setLastName("");
        account.setAddress(address);
        account.setEmail("");
        account.setLogin(null);
        account.setId(1);
        account.setBill(null);
        assertFalse(account.validate());

        //Test equal
        assertTrue(account.equals(account));
        assertFalse(account.equals(obj));

        //Test bill
        bill.setName("bill");
        bill.setAmount(5);
        bill.setDueDate("01/01/15");
        bill.setId(1);
        assertTrue(bill.validate());

        //Test a true Validate
        assertTrue(bill.validate());

        //Test a false Validate
        bill.setName("");
        bill.setAmount(0);
        bill.setDueDate("");
        bill.setId(0);
        assertFalse(bill.validate());

        //Test equals
        assertTrue(bill.equals(bill));
        assertFalse(bill.equals(obj));
    }
}
