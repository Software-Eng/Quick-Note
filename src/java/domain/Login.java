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
public class Login extends DomainAbs {

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean validate() {
        if (!(super.validate())) {
            return false;
        }
        if (username == null) {
            return false;
        }
        if (password == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Login)) {
            return false;
        }
        Login login = (Login) obj;
        if (login.id != id) {
            return false;
        }
        if (login.username != username) {
            return false;
        }
        return true;
    }
}
