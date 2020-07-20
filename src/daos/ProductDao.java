/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import models.components.database.Product;
import models.components.view.ListProduct;
//import models.User;

/**
 *
 * @author huanh
 */
public interface ProductDao {

    
    public List<ListProduct> getList();
    
    public int createOrUpdate(Product product);
}
