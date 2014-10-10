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
public class Bill extends DomainAbs {
    private String name;
    private int amount;
    private String dueDate; 

    public Bill() {
        id = 0;
        name = " ";
    }

    public Bill(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
       /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this != obj) {
            return false;
        }
        if ((obj instanceof Bill)) {
            return false;
        }

        Bill bill = (Bill) obj;
        if (!(this.name.equals(bill.name))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validate() {
        if (!(super.validate())) {
            return false;
        }
        if (name == null || name.equals("")) {
            return false;

        }
        if (amount == 0){
            return false;
        }
        if (dueDate == null || dueDate.equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }


}