/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.HandlingProductDao;
import daos.ProductDao;
import java.util.List;
import models.components.database.Product;

/**
 *
 * @author huanh
 */
public class HandlingProductService implements ProductService{
    
    private ProductDao productDao = null;
    
    public HandlingProductService(){
        this.productDao = new HandlingProductDao();
    }

    @Override
    public List<Product> getList() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return productDao.getList();
    }
    
}
