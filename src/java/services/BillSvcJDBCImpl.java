/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Bill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO bill (name, amount, dueDate) VALUES (?,?,?)";
        String sql2 = "SELECT last_insert_id()";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bill.getName());
            pstmt.setInt(2, bill.getAmount());
            pstmt.setString(3, bill.getDueDate());
            pstmt.executeUpdate();
            PreparedStatement pstmt2 = connection.prepareStatement(sql2);
            ResultSet rs = pstmt2.executeQuery(sql2);
            if (rs.next()) {
                bill.setId(rs.getInt("last_insert_id()"));
            }
        } catch (Exception e) {
            System.out.println("BillPStmtSvcImpl.create EXCEPTION: " + e.getMessage());
        }
        return bill;
    }

    @Override
    public Bill retrieve(int id) {
        Bill bill = null;
        String sql = "SELECT * FROM bill WHERE id=?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("BillPStmtSvcImpl.retrieve EXCEPTION: " + e.getMessage());
        }
        return bill;
    }

    @Override
    public Bill update(Bill bill) {
        String sql = "UPDATE bill SET name= ?, amount= ?, dueDate= ? WHERE id=?";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bill.getName());
            pstmt.setInt(2, bill.getAmount());
            pstmt.setString(3, bill.getDueDate());
            pstmt.setInt(4, bill.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("BillPStmtSvcImpl.update EXCEPTION: " + e.getMessage());
        }
        return bill;
    }

    @Override
    public Bill delete(Bill bill) {
        String sql = "DELETE FROM bill WHERE id=?";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, bill.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("BillPStmtSvcImpl.delete EXCEPTION: " + e.getMessage());
        }
        return bill;
    }

    @Override
    public ArrayList<Bill> retrieve(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
