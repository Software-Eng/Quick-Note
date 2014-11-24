/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO login (username, password) VALUES (?,?)";
        String sql2 = "SELECT last_insert_id()";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, login.getUsername());
            pstmt.setString(2, login.getPassword());
            pstmt.executeUpdate();
            PreparedStatement pstmt2 = connection.prepareStatement(sql2);
            ResultSet rs = pstmt2.executeQuery(sql2);
            if (rs.next()) {
                login.setId(rs.getInt("last_insert_id()"));
            }
        } catch (Exception e) {
            System.out.println("LoginPStmtSvcImpl.create EXCEPTION: " + e.getMessage());
        }
        return login;
    }

    @Override
    public Login retrieve(int id) {
        Login login = null;
        String sql = "SELECT * FROM login WHERE id=?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                login = new Login();
                login.setId(rs.getInt("id"));
                login.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("LoginPStmtSvcImpl.retrieve EXCEPTION: " + e.getMessage());
        }
        return login;
    }

    @Override
    public ArrayList<Login> retrieve(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login delete(Login login) {
        String sql = "DELETE FROM login WHERE id=?";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, login.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("LoginPStmtSvcImpl.delete EXCEPTION: " + e.getMessage());
        }
        return login;
    }

    @Override
    public Login update(Login login) {   
        String sql = "UPDATE login SET username= ?, password= ? WHERE id=?";
        try (Connection connection = getConnection();) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, login.getUsername());
            pstmt.setString(2, login.getPassword());
            pstmt.setInt(3, login.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("LoginPStmtSvcImpl.update EXCEPTION: " + e.getMessage());
        }
        return login;    
    }
}
