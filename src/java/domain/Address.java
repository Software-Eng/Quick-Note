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
public class Address extends DomainAbs {

    private String zip;
    private String address;
    private String city;
    private int apartmentNumber = 0;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.address = Address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the apartmentNumber
     */
    public int getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * @param apartmentNumber the apartmentNumber to set
     */
    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this != obj) {
            return false;
        }
        if ((obj instanceof Address)) {
            return false;
        }

        Address address = (Address) obj;
        if (address.id != id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validate() {
        if (!(super.validate())) {
            return false;
        }
        if (address == null || address.equals("")) {
            return false;
        }
        if (city == null || city.equals("")) {
            return false;
        }
        if (zip == null || zip.equals("")) {
            return false;
        }
        if (apartmentNumber == 0) {
            return false;
        }
        return true;
    }

}
