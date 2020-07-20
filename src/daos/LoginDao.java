/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.components.database.User;

/**
 *
 * @author huanh
 */
public interface LoginDao {
    public User login(String nameuser, String password);
}
