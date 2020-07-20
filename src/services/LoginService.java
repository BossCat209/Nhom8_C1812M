/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.components.database.User;

/**
 *
 * @author huanh
 */
public interface LoginService {
    public User login(String nameuser, String password);
}
