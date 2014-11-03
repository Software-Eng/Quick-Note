/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class AccountSvcJDBCImpl implements IAccountSvc { //implements IAccountSvc{jdbc:mysql://localhost:3306/?user=root

    private final String CONNSTRING = "jdbc:mysql://localhost:3306/quickNote?user=root&password=admin";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNSTRING);
    }

    public Account store(Account account) throws ServiceException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            //Construct the SQL string
            String sql = "INSERT INTO account (firstName, lastName) VALUES ('" + account.getFirstName() + "', '" + account.getLastName() + "')";
            //Fetches and assigns id    
            statement.executeUpdate(sql);
            sql = "SELECT last_insert_id()";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                account.setId(rs.getInt("last_insert_id()"));
            }
            connection.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return account;
    }

    //        Connection conn = null;
//        try {
//            conn = getConnection();
//        } catch (Exception e) {
//            throw new ServiceException(e.getMessage());
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
//        }
    @Override
    public Account retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account delete(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Account> retrieve(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
