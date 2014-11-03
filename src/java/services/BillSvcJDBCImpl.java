/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Bill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class BillSvcJDBCImpl implements IBillSvc {

    private final String CONNSTRING = "jdbc:mysql://localhost:3306/quickNote?user=root&password=admin";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNSTRING);
    }

    @Override
    public Bill create(Bill bill) throws ServiceException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            //Construct the SQL string
            String sql = "INSERT INTO bill (name, amount, dueDate) VALUES ('" + bill.getName() + "', '" + bill.getAmount() + "', '" + bill.getDueDate() + "')";
            //Fetches and assigns id    
            statement.executeUpdate(sql);
            sql = "SELECT last_insert_id()";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                bill.setId(rs.getInt("last_insert_id()"));
            }
            connection.close();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return bill;
    }

    @Override
    public Bill retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill update(Bill bill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill delete(Bill bill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Bill> retrieve(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
