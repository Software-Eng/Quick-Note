/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Account;
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
 * @author Vanguard
 */
public class BillSvcSIOImplTest {

    @Test
    public void testStore() throws Exception {
        Bill bill = new Bill();
        BillSvcSIOImpl billSvc = new BillSvcSIOImpl();
        bill.setName("Rent");
        bill.setAmount(447);
        bill.setDueDate("9/1/2014");
        try {
            assertSame(billSvc.store(bill), bill);
        } catch (Exception e) {
            fail("Could not persist" + e.getMessage());
        }
        assertNotNull(billSvc.store(bill));
    }
}
