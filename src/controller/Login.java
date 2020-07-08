/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ConnectDB;

/**
 *
 * @author huanh
 */
public class Login {
    public static Connection conn = null;
    public static ResultSet rs = null;

    public ResultSet UserLogin(String name, String pass){
        try {
            conn = ConnectDB.getConnection();
            String sql = "SELECT * FROM users where name = ? and password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pass);
            return rs = pst.executeQuery();
            } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return rs = null;
        }
    }
}
