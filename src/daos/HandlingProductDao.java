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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.components.database.Product;
import services.ConnectDB;
import services.HandlingProductService;

/**
 *
 * @author huanh
 */
public class HandlingProductDao implements ProductDao{

    @Override
    public List<Product> getList() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection conn = ConnectDB.getConnection();
        String sql = "SELECT * FROM products";
//                + "FROM products "
//                + "INNER JOIN users ON products.id_user_create = users.id "
//                + "INNER JOIN colors ON products.id_color = colors.id "
//                + "INNER JOIN sizes ON products.id_size = sizes.id "
//                + "INNER JOIN brands ON products.id_brand = brands.id";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName_product(rs.getString("name_product"));
                product.setId_user_create(rs.getInt("id_user_create"));
                product.setId_color(rs.getInt("id_color"));
                product.setId_size(rs.getInt("id_size"));
                product.setId_brand(rs.getInt("id_brand"));
//                product.setCreated_at(rs.getDate("created_at"));
//                product.setUpdated_at(rs.getDate("updated_at"));
                list.add(product);
            }
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HandlingProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
