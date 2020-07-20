/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JTextField;
import models.components.database.Product;
import services.HandlingProductService;
import services.ProductService;

/**
 *
 * @author huanh
 */
public class CRUDProductController {

    private final JButton jbnSubmit;
    private final JTextField jtfNameProduct;
    private final JTextField jtfIdCreate;
    private final JTextField jtfIdSize;
    private final JTextField jtfIdColor;
    private final JTextField jtfIdBrand;
    private final JLabel jlbNotify;
    private Product product = null;
    private ProductService productService = null;

    public CRUDProductController(JButton jbnSubmit, JTextField jtfNameProduct, JTextField jtfIdCreate, JTextField jtfIdSize, JTextField jtfIdColor, JTextField jtfIdBrand, JLabel jlbNotify) {
        this.jbnSubmit = jbnSubmit;
        this.jtfNameProduct = jtfNameProduct;
        this.jtfIdCreate = jtfIdCreate;
        this.jtfIdSize = jtfIdSize;
        this.jtfIdColor = jtfIdColor;
        this.jtfIdBrand = jtfIdBrand;
        this.jlbNotify = jlbNotify;
        this.productService = new HandlingProductService();
    }

    public void setView(Product product) {
        this.product = product;
//        if (product.getName_product().isEmpty()) {
//            jtfNameProduct.setText("");
//        } else {
//            jtfNameProduct.setText(product.getName_product());
//        }
        jtfNameProduct.setText(product.getName_product());
        jtfIdCreate.setText("#" + product.getId_user_create());
        jtfIdSize.setText("#" + product.getId_size());
        jtfIdColor.setText("#" + product.getId_color());
        jtfIdBrand.setText("#" + product.getId_brand());
        setEvent();
    }

    private void setEvent() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        jbnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                try {
                    if (!checkNotNull()) {
                        jlbNotify.setText("Vui lòng nhập dữ liệu!");
                    } else {
                        product.setName_product(jtfNameProduct.getText().trim());
//                    product.setId_user_create((int) jtfIdCreate.getText().);
                        if (showDialog()) {
                            int lastId = productService.createOrUpdate(product);
                            if (lastId != 0) {
                                product.setId(lastId);
                                jlbNotify.setText("Cập nhật thành công");
                            } else {
                                jlbNotify.setText("Cập nhật thất bại!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbNotify.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                jbnSubmit.setBackground(new Color(0, 100, 100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                jbnSubmit.setBackground(new Color(100, 200, 200));
            }

        });
    }

    private boolean checkNotNull() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return jtfNameProduct.getText() != null && !jtfNameProduct.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_NO_OPTION;
    }

}
