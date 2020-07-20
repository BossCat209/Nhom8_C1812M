/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.components.database.User;
import services.ConnectDB;

/**
 *
 * @author huanh
 */
public class HandlingLoginDao implements LoginDao {

    @Override
    public User login(String nameuser, String password) {
        Connection conn = ConnectDB.getConnection();
        String sql = "SELECT * FROM users WHERE name_user = ? AND password = ?";
        User user = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nameuser);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName_user(rs.getString("name_user"));
                user.setPassword(rs.getString("password"));
            }
            ps.close();
            conn.close();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(HandlingLoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
