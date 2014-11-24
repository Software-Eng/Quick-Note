/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import services.*;
import domain.*;

/**
 *
 * @author Steven
 */
public class AuthMgr {

    public boolean process(Login login) throws ServiceException{
        try {
            Factory factory = new Factory();
            //IAuthSvc authSvc = (IAuthSvc) factory.getService(IAuthSvc.NAME);
            //return authSvc.authenticate(login);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            Log failed login
        }
        return false;
    }
}