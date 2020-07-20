/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.components.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
//import models.components.database.Product;

/**
 *
 * @author huanh
 */
public class TableView {

    /**
     *
     * @param listProduct
     * @param listColumn
     * @return
     */
    public DefaultTableModel setTableProduct(List<ListProduct> listProduct, String[] listColumn) {
        int column = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column) {
//                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            return false;
            }

//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
////                return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
//                return columnIndex == 5 ? Boolean.class : String.class;
//            }
            
            
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listProduct.size();
        for (int i = 0; i < num; i++) {
            obj = new Object[column];
            ListProduct listPro = listProduct.get(i);
            obj[0] = (i + 1);
            obj[1] = listPro.getName_product();
            obj[2] = listPro.getName_user();
            obj[3] = listPro.getSize();
            obj[4] = listPro.getColor();
            obj[5] = listPro.getBrand();
//            obj[6] = product.getCreated_at();
//            obj[7] = product.getUpdated_at();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
