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
public class Account extends DomainAbs{
    private Login login;
    private Bill bill;
    private Address address;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return the bill
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this != obj) {
            return false;
        }
        if ((obj instanceof Account)) {
            return false;
        }

        Account account = (Account) obj;
        if (account.id != id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validate() {
        if (!(super.validate())) {
            return false;
        }
        if (firstName == null || firstName.equals("")) {
            return false;
        }
        if (lastName == null || lastName.equals("")) {
            return false;
        }
        
        if (email == null || email.equals("")) {
            return false;
        }
        if (login == null){
            return false;
        }
        if (address == null){
            return false;
        }
        if (bill == null){
            return false;
        }
        return true;
    }
}
