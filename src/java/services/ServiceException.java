/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Steven
 */
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }

    public ServiceException(String msg) {
        super(msg);
    }
}
