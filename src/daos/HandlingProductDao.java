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
import models.components.view.ListProduct;
import services.ConnectDB;
import services.HandlingProductService;

/**
 *
 * @author huanh
 */
public class HandlingProductDao implements ProductDao {

    Connection conn = ConnectDB.getConnection();

    @Override
    public List<ListProduct> getList() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Connection conn = ConnectDB.getConnection();
        String sql = "SELECT products.*, users.name_user, colors.name_color, sizes.name_size, brands.name_brand "
                + "FROM products "
                + "INNER JOIN users ON products.id_user_create = users.id "
                + "INNER JOIN colors ON products.id_color = colors.id "
                + "INNER JOIN sizes ON products.id_size = sizes.id "
                + "INNER JOIN brands ON products.id_brand = brands.id";
        List<ListProduct> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ListProduct listPro = new ListProduct();
                listPro.setName_product(rs.getString("name_product"));
                listPro.setName_user(rs.getString("name_user"));
                listPro.setSize(rs.getString("name_size"));
                listPro.setColor(rs.getString("name_color"));
                listPro.setBrand(rs.getString("name_brand"));
//                product.setCreated_at(rs.getDate("created_at"));
//                product.setUpdated_at(rs.getDate("updated_at"));
                list.add(listPro);
            }
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HandlingProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int createOrUpdate(Product product) {
        try {
            //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //        Connection conn = ConnectDB.getConnection();
            String sql = "INSERT INTO products(name_product, id_user_create, id_color, id_size, id_brand) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName_product());
            ps.setInt(2, product.getId_user_create());
            ps.setInt(3, product.getId_color());
            ps.setInt(4, product.getId_size());
            ps.setInt(5, product.getId_brand());
//            ps.setDate(6, product.getCreated_at());
//            ps.setDate(7, product.getUpdated_at());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            conn.close();
            return generatedKey;
        } catch (SQLException ex) {
            Logger.getLogger(HandlingProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;                                                                       
    }
}
