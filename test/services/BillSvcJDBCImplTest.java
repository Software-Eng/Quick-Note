/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Bill;
import java.util.List;
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
public class BillSvcJDBCImplTest {

    @Test
    public void testCreate() throws Exception {
        IBillSvc impl = new BillSvcJDBCImpl();
        Bill bill = new Bill();
        bill.setName("Rent");
        bill.setAmount(447);
        bill.setDueDate("9/1/2014");
        bill = impl.create(bill);
        assertNotNull(bill);
        assertSame(impl.create(bill), bill);
        assertTrue("9/1/2014".equals(bill.getDueDate()));
        assertFalse(bill.getId() == 0);
        System.out.println("The created bill was: " + bill);
        // test retrieve id
        bill = impl.retrieve(bill.getId());
        assertNotNull(bill);
        // test retrieve by id number
        bill = impl.retrieve(1);
        assertNotNull(bill);
        // Test update
        bill = impl.update(bill);
        bill.setName("Atari");
        bill.setAmount(500);
        assertNotNull(bill);
        assertEquals("Atari", bill.getName());
        // Test delete
        bill = impl.delete(impl.retrieve(1));
        assertEquals(null, impl.retrieve(1));
    }

}
