/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class LoginSvcJDBCImpl implements ILoginSvc {

    private final String CONNSTRING = "jdbc:mysql://localhost:3306/quickNote?user=root&password=admin";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNSTRING);
    }

    public Login store(Login login) throws ServiceException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            //Construct the SQL string
            String sql = "INSERT INTO login (username, password) VALUES ('" + login.getUsername() + "', '" + login.getPassword() + "')";
            //Fetches and assigns id    
            statement.executeUpdate(sql);
            sql = "SELECT last_insert_id()";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                login.setId(rs.getInt("last_insert_id()"));
            }
            connection.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return login;
    }

    @Override
    public Login retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Login> retrieve(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login delete(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
