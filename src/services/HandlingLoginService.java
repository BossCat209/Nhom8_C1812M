/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.HandlingLoginDao;
import daos.LoginDao;
import models.components.database.User;

/**
 *
 * @author huanh
 */
public class HandlingLoginService implements LoginService {

    private LoginDao loginDao = null;

    public HandlingLoginService() {
        loginDao = new HandlingLoginDao();
    }

    @Override
    public User login(String nameuser, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return loginDao.login(nameuser, password);
    }
    
    
}
