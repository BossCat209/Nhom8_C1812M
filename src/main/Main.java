/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import views.LoginJDialog;

/**
 *
 * @author huanh
 */
public class Main {
     /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        new MainJForm().setVisible(true);
        LoginJDialog login = new LoginJDialog(null, true);
        login.setTitle("Đăng nhập hệ thồng");
        login.setResizable(true);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
