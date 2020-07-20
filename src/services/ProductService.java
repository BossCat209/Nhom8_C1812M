/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.components.database.Product;
import models.components.view.ListProduct;

/**
 *
 * @author huanh
 */
public interface ProductService {
    public List<ListProduct> getList();
    
    public int createOrUpdate(Product product);
}
