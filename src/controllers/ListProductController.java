/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.components.database.Product;
import models.components.view.ListProduct;
import models.components.view.TableView;
import services.HandlingProductService;
import services.ProductService;
import views.ProductJFrame;

/**
 *
 * @author huanh
 */
public class ListProductController {

    private final JPanel jpnView;
    private final JButton jbtAdd;
    private final JTextField jtfSearch;

    private TableView productTable = null;
    private ProductService productService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNS;

    public ListProductController(JPanel jpnView, JButton jbtAdd, JTextField jtfSearch) {
        this.COLUMNS = new String[]{"STT", "Tên sản phẩm", "Admin tạo", "Màu", "Size", "Hãng"};
        this.jpnView = jpnView;
        this.jbtAdd = jbtAdd;
        this.jtfSearch = jtfSearch;
        this.productTable = new TableView();
        this.productService = new HandlingProductService();
    }
    
//    public void setAdd() {
//        Product product = null;
//        jbtAdd.add(new ProductJFrame(product));
//        jbtAdd.validate();
//        jbtAdd.repaint();
//    }

    public void setDataTable() {
        List<ListProduct> listProduct = productService.getList();
        DefaultTableModel model = productTable.setTableProduct(listProduct, COLUMNS);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);

        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();

                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    Product product = new Product();
                    product.setName_product(model.getValueAt(selectedRowIndex, 1).toString());
                    product.setId_user_create((int) model.getValueAt(selectedRowIndex, 2));
                    product.setId_size((int) model.getValueAt(selectedRowIndex, 3));
                    product.setId_color((int) model.getValueAt(selectedRowIndex, 4));
                    product.setId_brand((int) model.getValueAt(selectedRowIndex, 5));

                    ProductJFrame frame = new ProductJFrame(product);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin học viên");
                    frame.setVisible(true);
                }
            }

        });

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.getRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
}



