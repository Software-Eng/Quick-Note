/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class FactoryTest {

    @Test
    public void testGetService() throws Exception {
        Factory factory = new Factory();
        IAccountSvc accountSvc = (IAccountSvc) factory.getService(IAccountSvc.NAME);
        assertNotNull(accountSvc);
        IBillSvc billSvc = (IBillSvc) factory.getService(IBillSvc.NAME);
        assertNotNull(billSvc);
        ILoginSvc loginSvc = (ILoginSvc) factory.getService(ILoginSvc.NAME);
        assertNotNull(loginSvc);

    }
}
