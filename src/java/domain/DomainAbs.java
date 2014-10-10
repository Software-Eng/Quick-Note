/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author Steven
 */
public abstract class DomainAbs {

    protected int id;

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public boolean validate() {
        if (id == 0) {
            return false;
        } else {
            return true;
        }
    }
}

  
