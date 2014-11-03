/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Login;
import java.util.ArrayList;

/**
 *
 * @author Vanguard
 */
interface ILoginSvc extends IService {

    public final String NAME = "ILoginSvc";

    public Login store(Login login) throws ServiceException;

    public Login retrieve(int id);

    public ArrayList<Login> retrieve(String lastName);

    public Login delete(Login login);
}
