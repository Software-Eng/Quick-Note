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
        String sql = "INSERT INTO account (name, amount, dueDate) VALUES (?,?,?)";
        String sql2 = "SELECT last_insert_id()";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, account.getFirstName());
            pstmt.setString(2, account.getLastName());
            pstmt.setString(3, account.getEmail());
            pstmt.executeUpdate();
            PreparedStatement pstmt2 = connection.prepareStatement(sql2);
            ResultSet rs = pstmt2.executeQuery(sql2);
            if (rs.next()) {
                account.setId(rs.getInt("last_insert_id()"));
            }
        } catch (Exception e) {
            System.out.println("AccountPStmtSvcImpl.create EXCEPTION: " + e.getMessage());
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
        Account account = null;
        String sql = "SELECT * FROM account WHERE id=?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setId(rs.getInt("id"));
                account.setFirstName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("AccountPStmtSvcImpl.retrieve EXCEPTION: " + e.getMessage());
        }
        return account;
    }

    @Override
    public Account delete(Account account) {
        String sql = "DELETE FROM account WHERE id=?";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, account.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("AccountPStmtSvcImpl.delete EXCEPTION: " + e.getMessage());
        }
        return account;
    }

    @Override
    public ArrayList<Account> retrieve(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account update(Account account) {
        String sql = "UPDATE account SET name= ?, amount= ?, dueDate= ? WHERE id=?";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, account.getFirstName());
            pstmt.setString(2, account.getLastName());
            pstmt.setString(3, account.getEmail());
            pstmt.setInt(4, account.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("AccountPStmtSvcImpl.update EXCEPTION: " + e.getMessage());
        }
        return account;
    }
}
